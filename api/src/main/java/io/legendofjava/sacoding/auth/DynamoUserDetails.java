package io.legendofjava.sacoding.auth;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.legendofjava.sacoding.dynamo.SAUser;
import io.legendofjava.sacoding.dynamo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DynamoUserDetails implements UserDetailsService {
	
	private final UserRepository repo;
	private final PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.debug("Checking for <{}>", email);
		Optional<SAUser> potentialUser = repo.findByEmail(email);
		var user = potentialUser.orElseThrow(() -> new UsernameNotFoundException("Could not find user for " + email));

		// Might need to do password check here...
		return new User(email, user.getPassword(), getAuthorities(user.getRole()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
		return List.of(new SimpleGrantedAuthority(role.privilege()));
	}

	/**
	 * Registers a new user as {@value Role#UNASSIGNED}.
	 * 
	 * @param req
	 * @return the generated id for the user
	 * @throws RuntimeException if provided email is not unique
	 */
	public String register(LoginRequest req) {
		log.debug("Trying to register <{}>", req.getUsername());
		
		var potentialUser = repo.findByEmail(req.getUsername());
		if (potentialUser.isPresent())
			throw new RuntimeException("User " + req.getUsername() + " already exists");

		var hashedPass = encoder.encode(req.getPassword());
		SAUser user = repo.save(new SAUser(req.getUsername(), hashedPass, Role.UNASSIGNED));
		return user.getId();
	}

}

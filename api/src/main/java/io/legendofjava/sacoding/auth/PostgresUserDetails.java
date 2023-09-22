package io.legendofjava.sacoding.auth;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
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

import io.legendofjava.sacoding.Enum.Role;
import io.legendofjava.sacoding.auth.dto.RegisterRequest;
import io.legendofjava.sacoding.auth.dto.Verification;
import io.legendofjava.sacoding.auth.event.RegistrationRepository;
import io.legendofjava.sacoding.auth.event.RegistrationToken;
import io.legendofjava.sacoding.entity.SAUser;
import io.legendofjava.sacoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostgresUserDetails implements UserDetailsService {

	private final UserRepository repo;
	private final PasswordEncoder encoder;
	private final RegistrationRepository registrationRepo;

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
	public String register(RegisterRequest req) {
		log.debug("Trying to register <{}>", req.getEmail());

		var potentialUser = repo.findByEmail(req.getEmail());
		if (potentialUser.isPresent())
			throw new RuntimeException("User " + req.getEmail() + " already exists");

		var hashedPass = encoder.encode(req.getPassword());
		SAUser newUser = new SAUser();
		newUser.setEmail(req.getEmail());
		newUser.setFirstName(req.getFirstName());
		newUser.setLastName(req.getLastName());
		newUser.setPassword(hashedPass);
		newUser.setRole(Role.UNVERIFIED);

		SAUser user = repo.save(newUser);
		return user.getId();
	}
	
	public boolean verifyNewUser(Verification verification) {
		log.debug("Trying to verify <{}>", verification.getEmail());
		var registration = registrationRepo.findById(verification.getEmail());
		
		if(registration.isPresent()) {
			RegistrationToken r = registration.get();
			var token = r.getToken();
			var expiry = r.getExpiryDate();
			
			if(expiry.after(Date.from(Instant.now())) && token.equals(verification.getToken())) {
				Optional<SAUser> user = repo.findByEmail(verification.getEmail());
				user.ifPresent(u -> {
					u.setRole(Role.UNASSIGNED);
					repo.save(u);
					registrationRepo.delete(r);
				});
				return true;
			}
		}
		
		return false;
	}

}

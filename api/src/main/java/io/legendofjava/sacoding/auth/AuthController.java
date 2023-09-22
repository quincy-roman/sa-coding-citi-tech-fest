package io.legendofjava.sacoding.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.legendofjava.sacoding.auth.dto.LoginRequest;
import io.legendofjava.sacoding.auth.dto.RegisterRequest;
import io.legendofjava.sacoding.auth.dto.Verification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

	private final PostgresUserDetails userService;
	private final AuthenticationManager authManager;

	private final SecurityContextRepository securityContextRepo;
	private final SecurityContextHolderStrategy securityStrat = SecurityContextHolder.getContextHolderStrategy();

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public void login(@RequestBody LoginRequest loginReq, HttpServletRequest req, HttpServletResponse res) {
		log.info("User <{}> logging in", loginReq.getUsername());

		var token = UsernamePasswordAuthenticationToken.unauthenticated(loginReq.getUsername(), loginReq.getPassword());
		Authentication auth = authManager.authenticate(token);

		SecurityContext context = securityStrat.createEmptyContext();
		context.setAuthentication(auth);
		securityStrat.setContext(context);

		log.debug("Saving new context: {}", context);
		securityContextRepo.saveContext(context, req, res);
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> register(@RequestBody RegisterRequest registerReq) {
		String id = userService.register(registerReq, ServletUriComponentsBuilder.fromCurrentContextPath());
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentContextPath().pathSegment("api", "learners", id).build().toUri())
				.build();
	}

	@PostMapping("/verify")
	public ResponseEntity<Object> verify(@RequestBody Verification verification) {
		return userService.verifyNewUser(verification) ? ResponseEntity.ok().build()
				: ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	@PostMapping("/logout")
	public void logout() {
	}
}
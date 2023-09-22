package io.legendofjava.sacoding.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter.Directive;

import io.legendofjava.sacoding.Enum.Role;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterchain(HttpSecurity http, SecurityContextRepository repo) throws Exception {
		// Session timeout is set in application.yaml
		// Disabling csrf as it's causing issues with POST requests, can't figure it out quickly
		http.csrf(csrf -> csrf.disable())
			.securityContext(context -> context.securityContextRepository(repo))
			.authorizeHttpRequests(auth -> 
				auth.antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/fill").permitAll()
					.antMatchers(HttpMethod.POST, "/login", "/register").permitAll()
					.antMatchers("/facilitators/**").hasRole(Role.FACILITATOR.name())
					.antMatchers("learning/**").hasRole(Role.LEARNER.name())
					.antMatchers("/admin/**").hasRole(Role.ADMIN.name())
					.anyRequest().authenticated())
			.logout(logout -> logout.logoutUrl("/logout").addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(Directive.COOKIES))).permitAll());

		return http.build();
	}

	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	AuthenticationProvider authenticationProvider(PasswordEncoder encoder, UserDetailsService service) {
		// This will perform the authentication via the AuthenticationManager
		var provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder);
		provider.setUserDetailsService(service);
		return provider;
	}

	@Bean
	SecurityContextRepository secConRepo() {
		return new HttpSessionSecurityContextRepository();
	}

}

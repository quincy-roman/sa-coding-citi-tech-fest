package io.legendofjava.sacoding.auth.event;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import io.legendofjava.sacoding.Enum.Role;
import io.legendofjava.sacoding.entity.SAUser;
import io.legendofjava.sacoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationListener {

	private final JavaMailSender mail;
	private final RegistrationRepository repo;
	private final TaskScheduler scheduler;
	private final UserRepository userRepo;

	@Async
	@EventListener
	public void handleOnRegistrationEvent(OnRegistrationEvent event) {
		var email = event.getEmail();
		var token = UUID.randomUUID().toString();
		var expiryDate = Date.from(ZonedDateTime.now(ZoneId.systemDefault()).plusDays(1).toInstant());

		RegistrationToken registration = RegistrationToken.from(email, token, expiryDate);
		registration = repo.save(registration);
		scheduler.schedule(scheduleRemoval(email), expiryDate);

		var verificationUrl = event.getBaseUrl().pathSegment("verify").queryParam("token", token).queryParam("email", email).build().toString();
		
		// TODO: make a prettier email
		var emailMessage = new SimpleMailMessage();
		emailMessage.setTo(email);
		emailMessage.setSubject("Registration Confirmation");
		emailMessage.setText("Follow the link to confirm your account for SACoding: " + verificationUrl + ".\n\nIf you did not submit this request, please ignore this mail. Do not follow the link above.");

		mail.send(emailMessage);
	}

	private Runnable scheduleRemoval(String email) {
		return () -> {
			log.info("Cleaning token table");
			repo.deleteById(email);
			Optional<SAUser> user = userRepo.findByEmail(email);
			user.ifPresent(u -> {
				if (u.getRole() == Role.UNVERIFIED)
					userRepo.delete(u);
			});
		};
	}

}

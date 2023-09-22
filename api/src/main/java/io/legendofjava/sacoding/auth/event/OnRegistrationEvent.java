package io.legendofjava.sacoding.auth.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriBuilder;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class OnRegistrationEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 136555614517879063L;
	
	private final String email;
	private final UriBuilder baseUrl;

	public OnRegistrationEvent(String email, UriBuilder contextPath) {
		super(email);
		this.email = email;
		this.baseUrl = contextPath;
	}

}

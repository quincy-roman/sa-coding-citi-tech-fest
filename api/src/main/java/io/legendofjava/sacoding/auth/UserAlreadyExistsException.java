package io.legendofjava.sacoding.auth;

public class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 4902095294191349435L;

	public UserAlreadyExistsException() { }

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}

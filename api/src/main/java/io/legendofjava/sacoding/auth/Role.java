package io.legendofjava.sacoding.auth;

public enum Role {
	
	ADMIN, FACILITATOR, LEARNER, UNASSIGNED;
	
	private Role() {
		this.role = "ROLE_" + this.name();
	}
	
	private String role;
	
	public String privilege() {
		return this.role;
	}
}

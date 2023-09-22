package io.legendofjava.sacoding.auth.dto;

import lombok.Data;

@Data
public class Verification {
	private String email;
	private String token;
}
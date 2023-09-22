package io.legendofjava.sacoding.auth.event;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "REGISTRATION_TOKEN")
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class RegistrationToken {
	
	@Id
	private String email;
	
	private String token;
	
	private Date expiryDate;
	
}

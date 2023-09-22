package io.legendofjava.sacoding.auth.event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<RegistrationToken, String> {

}

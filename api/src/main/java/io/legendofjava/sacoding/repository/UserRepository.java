package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.SAUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<SAUser, String> {

    Optional<SAUser> findByEmail(String email);

    Set<UserDTO> findByBatchId(String batchId);

    interface UserDTO{
        String getId();
        @Value("#{target.lastName + ', ' + target.firstName}")
        String getFullName();

    }
}

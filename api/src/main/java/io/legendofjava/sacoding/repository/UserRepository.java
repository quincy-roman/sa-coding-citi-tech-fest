package io.legendofjava.sacoding.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.SAUser;

public interface UserRepository extends JpaRepository<SAUser, String> {

    Optional<SAUser> findByEmail(String email);

    Set<UserDTO> findByBatchId(String batchId);

    interface UserDTO{
        String getId();
        @Value("#{target.lastName + ', ' + target.firstName}")
        String getFullName();

    }
}

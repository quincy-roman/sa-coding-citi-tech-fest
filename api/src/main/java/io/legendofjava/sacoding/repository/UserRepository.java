package io.legendofjava.sacoding.repository;

import org.springframework.beans.factory.annotation.Value;
import io.legendofjava.sacoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {

    Set<UserDTO> findByBatchId(String batchId);

    interface UserDTO{
        String getId();
        @Value("#{target.lastName + ', ' + target.firstName}")
        String getFullName();

    }
}

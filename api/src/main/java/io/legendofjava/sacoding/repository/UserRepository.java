package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    //User getById(String id);
    Optional<User> findById(String id);

    List<User> findByLName(String lName);
}

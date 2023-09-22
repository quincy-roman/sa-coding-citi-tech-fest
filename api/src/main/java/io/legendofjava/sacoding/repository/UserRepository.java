package io.legendofjava.sacoding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByLName(String lName);
}

package io.legendofjava.sacoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}

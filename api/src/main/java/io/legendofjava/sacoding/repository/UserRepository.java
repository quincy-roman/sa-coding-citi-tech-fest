package io.legendofjava.sacoding.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.SAUser;

public interface UserRepository extends JpaRepository<SAUser, String> {
    Optional<SAUser> findByEmail(String email);
}

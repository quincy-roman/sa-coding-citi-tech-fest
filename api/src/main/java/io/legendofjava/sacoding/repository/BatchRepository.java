package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepository extends JpaRepository<Batch, String> {
    Optional<Batch> findById(String id);

}

package io.legendofjava.sacoding.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, String> {

    Optional<Batch> findById(String id);

	Set<Batch> findByFacilitatorId(String facilitatorId);

}

package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    Optional<Event> findById(String id);

}

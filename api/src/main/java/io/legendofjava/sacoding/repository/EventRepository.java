package io.legendofjava.sacoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.Event;

public interface EventRepository extends JpaRepository<Event, String> {

}

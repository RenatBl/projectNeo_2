package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}

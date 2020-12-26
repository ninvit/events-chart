package ninvit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ninvit.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> { }
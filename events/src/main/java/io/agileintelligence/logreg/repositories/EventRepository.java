package io.agileintelligence.logreg.repositories;

import io.agileintelligence.logreg.models.Event;
import io.agileintelligence.logreg.models.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findAllByState(String state);
    List<Event> findAllByStateNot(String state);
    Event findById(Long id);



//    long countEventByUsers();


}

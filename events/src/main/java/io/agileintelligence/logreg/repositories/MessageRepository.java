package io.agileintelligence.logreg.repositories;

import io.agileintelligence.logreg.models.Event;
import io.agileintelligence.logreg.models.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Messages, Long> {



}

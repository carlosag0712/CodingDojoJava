package io.carlosarosemena.dojooverflow.Repositories;

import io.carlosarosemena.dojooverflow.Models.Answers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answers, Long>{
}

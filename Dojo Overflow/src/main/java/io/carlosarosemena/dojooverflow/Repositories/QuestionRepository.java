package io.carlosarosemena.dojooverflow.Repositories;

import io.carlosarosemena.dojooverflow.Models.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Questions, Long> {

    List<Questions> findAll();
}

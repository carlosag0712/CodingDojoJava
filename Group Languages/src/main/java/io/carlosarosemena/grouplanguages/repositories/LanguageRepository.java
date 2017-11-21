package io.carlosarosemena.grouplanguages.repositories;

import io.carlosarosemena.grouplanguages.models.language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<language, Long> {

    List<language> findAll();


}

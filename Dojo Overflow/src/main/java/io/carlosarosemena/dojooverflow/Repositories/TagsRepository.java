package io.carlosarosemena.dojooverflow.Repositories;

import io.carlosarosemena.dojooverflow.Models.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends CrudRepository<Tags, Long> {
    Tags findBySubject(String subject);
}

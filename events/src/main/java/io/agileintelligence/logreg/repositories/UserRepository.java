package io.agileintelligence.logreg.repositories;

import io.agileintelligence.logreg.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    long count();
}

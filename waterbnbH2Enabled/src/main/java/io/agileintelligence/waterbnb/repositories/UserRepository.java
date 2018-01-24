package io.agileintelligence.waterbnb.repositories;

import io.agileintelligence.waterbnb.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);

    Users findById(Long Id);
}

package io.agileintelligence.waterbnb.repositories;

import io.agileintelligence.waterbnb.models.Roles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Roles, Long> {
    List<Roles> findAll();
    List<Roles> findByName(String name);
}

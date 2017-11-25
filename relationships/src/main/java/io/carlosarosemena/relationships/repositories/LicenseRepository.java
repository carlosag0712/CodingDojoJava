package io.carlosarosemena.relationships.repositories;


import io.carlosarosemena.relationships.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

}

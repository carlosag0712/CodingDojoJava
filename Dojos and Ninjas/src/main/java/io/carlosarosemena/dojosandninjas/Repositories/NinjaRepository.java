package io.carlosarosemena.dojosandninjas.Repositories;

import io.carlosarosemena.dojosandninjas.Models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
}

package io.agileintelligence.waterbnb.repositories;

import io.agileintelligence.waterbnb.models.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListingRepository extends CrudRepository<Listing, Long> {

    List<Listing> findAll();
    List<Listing> findByAddressContaining(String search);
    Listing findById(Long id);
}

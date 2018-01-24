package io.agileintelligence.waterbnb.repositories;

import io.agileintelligence.waterbnb.models.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}

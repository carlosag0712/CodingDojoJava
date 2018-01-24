package io.agileintelligence.waterbnb.services;


import io.agileintelligence.waterbnb.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private UserService userService;

    @Autowired
    private ListingService listingService;


//    public void saveRating(Rating rating, Long lid, String username) {
//
//        rating.setListings(listingService.findById(lid));
//
//
//    }
}

package io.agileintelligence.waterbnb.services;

import io.agileintelligence.waterbnb.models.Listing;
import io.agileintelligence.waterbnb.models.Rating;
import io.agileintelligence.waterbnb.models.Users;
import io.agileintelligence.waterbnb.repositories.ListingRepository;
import io.agileintelligence.waterbnb.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private RatingRepository ratingRepository;

    public void saveListing(Listing listing, Users users){
        listing.setUser(users);
        listing.setRating_average(avgRating(listing.getId()));
        listingRepository.save(listing);
    }

    public List<Listing> findListings(String search){
        try {
            if(search.length()>=1){
                return listingRepository.findByAddressContaining(search);
            }

        }catch (Exception e){
            return listingRepository.findAll();

        }
        return listingRepository.findAll();

    }

    public Listing findById(Long id){
       return listingRepository.findById(id);
    }

    public void addReviewToListing(Rating rating, Long lid){

        Listing listing = listingRepository.findById(lid);
        List<Rating> ratings = listing.getRatings();
        List<Listing> listings = rating.getListings();
        ratings.add(rating);
        listing.setRating_average(avgRating(lid));
        listings.add(listing);


        listingRepository.save(listing);
        ratingRepository.save(rating);

    }

    public double avgRating(Long id){
        double intTotal = 0;

        List<Rating> ratings = listingRepository.findById(id).getRatings();

        for(int i=0;i<ratings.size();i++){
            intTotal += ratings.get(i).getRating();
        }

        double avgRating = intTotal / ratings.size();


        Listing listing = listingRepository.findById(id);
        listing.setRating_average(avgRating);
        listingRepository.save(listing);

        return avgRating;
    }


}

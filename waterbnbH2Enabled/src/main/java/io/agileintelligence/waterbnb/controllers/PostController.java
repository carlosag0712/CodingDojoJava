package io.agileintelligence.waterbnb.controllers;

import io.agileintelligence.waterbnb.models.Listing;
import io.agileintelligence.waterbnb.models.Rating;
import io.agileintelligence.waterbnb.models.Users;
import io.agileintelligence.waterbnb.services.ListingService;
import io.agileintelligence.waterbnb.services.RatingService;
import io.agileintelligence.waterbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.ManyToMany;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/pools")
public class PostController {

    @Autowired
    private ListingService listingService;

    @Autowired
    private UserService userService;



    @RequestMapping("/{id}")
    public String placeDescription(@PathVariable("id")Long id, Model model, Principal principal){

        try {
            Users user = userService.findByUsername(principal.getName());
            model.addAttribute("currentUser", user);
            model.addAttribute("reviews", listingService.findById(id).getRatings());
            model.addAttribute("listing", listingService.findById(id));
            return "placeDesc";

        }catch (Exception e){
            model.addAttribute("listing", listingService.findById(id));
            model.addAttribute("reviews", listingService.findById(id).getRatings());

            return "placeDesc";
        }

    }

    @RequestMapping("/{id}/review")
    public String loadReviewForm(@ModelAttribute("rating")Rating rating, @PathVariable("id")Long id, Model model, Principal principal){
        Users user = userService.findByUsername(principal.getName());
        Listing listing = listingService.findById(id);
        model.addAttribute("currentUser", user);
        model.addAttribute("listing", listing);

        return "reviewForm";
    }

    @RequestMapping("/saveReview")
    public String saveReview(@Valid @ModelAttribute("rating")Rating rating,
                              @RequestParam("listingId")Long lid){

        listingService.addReviewToListing(rating,lid);


        return "redirect:/pools/"+lid;

    }




}

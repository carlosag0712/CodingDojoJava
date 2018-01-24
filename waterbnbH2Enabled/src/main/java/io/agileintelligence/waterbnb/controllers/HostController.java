package io.agileintelligence.waterbnb.controllers;

import io.agileintelligence.waterbnb.models.Listing;
import io.agileintelligence.waterbnb.models.Users;
import io.agileintelligence.waterbnb.services.ListingService;
import io.agileintelligence.waterbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/host")
public class HostController {

    @Autowired
    private ListingService listingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"","/dashboard"})
    public String dashboard(@Valid @ModelAttribute("listing")Listing listing, Principal principal, Model model){

        Users users = userService.findByUsername(principal.getName());
        model.addAttribute("currentUser", users);

        return "dashboard";
    }

    @RequestMapping("/saveListing")
    public String saveListing(@Valid @ModelAttribute("listing")Listing listing, BindingResult result,
                              @RequestParam("userId")Long Id, Model model){

        if(result.hasErrors()){
            model.addAttribute("error", "one");
            return "dashboard";
        }

        Users user = userService.findById(Id);

        listingService.saveListing(listing, user);

        return "redirect:/host/dashboard";
    }

    @RequestMapping("/pools/{id}")
    public String loadUpdateform(@Valid @ModelAttribute("listing")Listing listing,BindingResult result,
                                 @PathVariable("id")Long id, Model model, Principal principal) {
        Users user = userService.findByUsername(principal.getName());
        listing = listingService.findById(id);
        model.addAttribute("currentUser", user);
        model.addAttribute("listing", listing);
        model.addAttribute("reviews", listingService.findById(id).getRatings());


        return "placeDescUpdate";

    }

    @RequestMapping("/pools/{id}/update")
    public String updatePost(@Valid @ModelAttribute("listing")Listing listing,BindingResult result,@RequestParam("userId")Long uid,
                             @PathVariable("id")Long id){

        if(result.hasErrors()){
            return "redirect:/pools/"+id;
        }

        Users user = userService.findById(uid);
        listingService.saveListing(listing, user);

        return "redirect:/host/dashboard";
    }
}

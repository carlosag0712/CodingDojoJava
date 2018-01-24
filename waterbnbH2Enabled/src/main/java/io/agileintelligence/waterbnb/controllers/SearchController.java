package io.agileintelligence.waterbnb.controllers;

import io.agileintelligence.waterbnb.models.Users;
import io.agileintelligence.waterbnb.services.ListingService;
import io.agileintelligence.waterbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @Autowired
    private ListingService listingService;


    @RequestMapping("/")
    public String searchMainPage(Principal principal, Model model){
        try {
            Users user = userService.findByUsername(principal.getName());
            model.addAttribute("currentUser", user);
            return "mainPage";
        }catch (Exception e){
            return "mainPage";

        }

    }



    @RequestMapping("/search")
    public String searchResultPage(Principal principal, Model model, @RequestParam(value = "search", required = false)String search){
        try{
            Users user = userService.findByUsername(principal.getName());
            model.addAttribute("currentUser", user);
            model.addAttribute("results", listingService.findListings(search));
            return "searchResult";

        }catch (Exception e){
            model.addAttribute("results", listingService.findListings(search));

            return "searchResult";
        }


    }


}

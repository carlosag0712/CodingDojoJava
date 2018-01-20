package io.agileintelligence.logreg.controllers;


import io.agileintelligence.logreg.Utility.USStates;
import io.agileintelligence.logreg.models.User;
import io.agileintelligence.logreg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

@Controller
public class UsersController {


    @Autowired
    private UserService userService;

    private static SimpleDateFormat formatter;


    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user")User user, Model model){
        List<String> stateList = USStates.listOfUSStatesCode;
        Collections.sort(stateList);
        model.addAttribute("stateList", stateList);
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user")User user, BindingResult result){

        String returnIfSuccess = "redirect:/login";
        String returnIfErrors = "registrationPage";

        return userService.checkRegistration(user, result, returnIfSuccess, returnIfErrors);
    }

    @RequestMapping(value ={"/","/login"})
    public String login( @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false)String logout, Model model){

        String jspPage ="loginPage";


        return userService.checkService(error,logout,model,jspPage);
    }


    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model){
        //DRY
        String jspPage ="adminPage";

        return userService.CheckUserService(principal, model, jspPage);
    }

    @RequestMapping("/denied")
    public String accessDeniedPage(Principal principal, Model model){
        //DRY
        String jspPage ="accessDenied";
        return userService.CheckUserService(principal, model, jspPage);
    }
}

package io.agileintelligence.logreg.services;

import io.agileintelligence.logreg.models.User;
import io.agileintelligence.logreg.repositories.UserRepository;
import io.agileintelligence.logreg.services.UserServices.CheckUserService;
import io.agileintelligence.logreg.services.UserServices.LoginLogoutMsgService;
import io.agileintelligence.logreg.services.UserServices.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;
import java.security.Principal;

@Service
public class UserService {

    @Autowired
    private LoginLogoutMsgService loginLogoutMsgService;

    @Autowired
    private CheckUserService checkUserService;

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private UserRepository userRepository;


    public void SaveUser(User user){
        userRegistrationService.SaveUser(user);
    }

    public String CheckUserService(Principal principal, Model model, String jspPage){
        return checkUserService.checkUserService(principal, model, jspPage);
    }

    public String checkService(String error, String logout, Model model, String jspPage) {
        return loginLogoutMsgService.checkLoginService(error,logout,model, jspPage);
    }

    public String checkRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, String returnIfSuccess, String returnIfErrors ) {
       return userRegistrationService.checkRegistration(user, result, returnIfSuccess, returnIfErrors );
    }

    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }


    }


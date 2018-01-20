package io.agileintelligence.logreg.services.UserServices;

import io.agileintelligence.logreg.models.User;
import io.agileintelligence.logreg.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Service
public class LoginLogoutMsgService {


    public String checkLoginService(String error, String logout, Model model, String jspPage) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }


        return jspPage;
    }




}

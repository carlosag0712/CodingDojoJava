package io.agileintelligence.waterbnb.controllers;

import io.agileintelligence.waterbnb.models.Roles;
import io.agileintelligence.waterbnb.models.Users;
import io.agileintelligence.waterbnb.services.RoleService;
import io.agileintelligence.waterbnb.services.UserService;
import io.agileintelligence.waterbnb.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/guest")
public class LogRegController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"/","/signin"})
    public String signin(@Valid @ModelAttribute("user")Users user, Model model){
        model.addAttribute("rolesList", roleService.findAll());
        model.addAttribute("success");
        return "loginReg";
    }

    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user")Users user, BindingResult result,
                               @RequestParam("account")String account, Model model){
        try {
            userValidator.validate(user,result);
            if(result.hasErrors()){
                model.addAttribute("error", "one");
                return "loginReg";
            }
            userService.saveUser(user, account);
            model.addAttribute("success", "Thank you for registering, please log in!");

            return "redirect:/guest/signin";
        }catch (Exception e){
            return "redirect:/guest/signin";

        }


    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error,
                        @RequestParam(value="logout", required=false) String logout, Model model){
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
            return "loginReg";
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
            return "loginReg";
        }

        return "redirect:/success";

    }

    @RequestMapping("/success")
    public String home(Principal principal, Model model){

            Users user  = userService.findByUsername(principal.getName());

            List<Roles> contains = user.getRoles();

            for(int i=0;i<contains.size();i++){
                if(contains.get(i).getName().equals("ROLE_HOST")){
                    return "redirect:/host/dashboard";
                }

            }
            return "redirect:/search";

        }

}

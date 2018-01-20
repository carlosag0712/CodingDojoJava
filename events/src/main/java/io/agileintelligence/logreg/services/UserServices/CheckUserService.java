package io.agileintelligence.logreg.services.UserServices;

import io.agileintelligence.logreg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;

@Service
public class CheckUserService {
    @Autowired
    private UserRepository userRepository;

    public String checkUserService(Principal principal, Model model, String jspPage) {
        String username = principal.getName();
        model.addAttribute("currentUser", userRepository.findByUsername(username));
        return jspPage;
    }
}

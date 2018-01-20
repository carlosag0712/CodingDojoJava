package io.agileintelligence.logreg.services.UserServices;

import io.agileintelligence.logreg.models.User;
import io.agileintelligence.logreg.repositories.RoleRepository;
import io.agileintelligence.logreg.repositories.UserRepository;
import io.agileintelligence.logreg.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Service
public class UserRegistrationService {

    //Save User
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private void saveWithUserRole(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }

    private void saveUserWithAdminRole(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }

    public void SaveUser(User user){
        if(userRepository.count()<1){
            saveUserWithAdminRole(user);
        }else{
            saveWithUserRole(user);
        }
    }

    public String checkRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, String returnIfSuccess, String returnIfErrors ) {
        userValidator.validate(user,result);
        if(result.hasErrors()){
            return returnIfErrors;
        }
        SaveUser(user);
        return returnIfSuccess;
    }

    //Save User - End

}

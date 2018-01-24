package io.agileintelligence.waterbnb.services;

import io.agileintelligence.waterbnb.models.Users;
import io.agileintelligence.waterbnb.repositories.RoleRepository;
import io.agileintelligence.waterbnb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveUser(Users user, String account){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(account.equals("host")){
            user.setRoles(roleRepository.findByName("ROLE_HOST"));
        }

        if(account.equals("guest")){
            user.setRoles(roleRepository.findByName("ROLE_GUEST"));
        }
        userRepository.save(user);
    }


    public Users findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Users findById(Long id){
        return userRepository.findById(id);
    }


}

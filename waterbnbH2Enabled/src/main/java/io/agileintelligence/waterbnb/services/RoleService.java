package io.agileintelligence.waterbnb.services;

import io.agileintelligence.waterbnb.models.Roles;
import io.agileintelligence.waterbnb.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Roles> findAll(){
        return roleRepository.findAll();
    }
}

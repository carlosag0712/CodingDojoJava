package io.agileintelligence.waterbnb.bootstrap;

import io.agileintelligence.waterbnb.models.Roles;
import io.agileintelligence.waterbnb.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LoadUserRoles implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Roles roles1 = new Roles();
        roles1.setName("ROLE_GUEST");

        Roles roles2 = new Roles();
        roles2.setName("ROLE_HOST");

        roleRepository.save(roles1);
        roleRepository.save(roles2);
    }
}

package io.agileintelligence.waterbnb;

import io.agileintelligence.waterbnb.models.Roles;
import io.agileintelligence.waterbnb.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaterbnbApplication {



	public static void main(String[] args) {
		SpringApplication.run(WaterbnbApplication.class, args);

	}


}

package io.agileintelligence.waterbnb.validators;

import io.agileintelligence.waterbnb.models.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Users user = (Users) object;
        if(!user.getConfPassword().equals(user.getPassword())){
            errors.rejectValue("confPassword", "Match");
        }

    }
}

package io.agileintelligence.logreg.validator;

import io.agileintelligence.logreg.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }



    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;

        if(!user.getPassword().equals(user.getPasswordConfirmation())){
            errors.rejectValue("passwordConfirmation","Match");
        }



    }
}

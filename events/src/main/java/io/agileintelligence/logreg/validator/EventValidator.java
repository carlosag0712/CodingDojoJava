package io.agileintelligence.logreg.validator;

import io.agileintelligence.logreg.models.Event;
import io.agileintelligence.logreg.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


@Component
public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }



    @Override
    public void validate(Object object, Errors errors) {
        Event event = (Event) object;
        Date date = Calendar.getInstance().getTime();
        if(event.getDate().before(date)){
            errors.rejectValue("wrongDate","Date");
        }
    }
}

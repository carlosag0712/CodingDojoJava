package io.agileintelligence.logreg.controllers;

import io.agileintelligence.logreg.Utility.USStates;
import io.agileintelligence.logreg.models.Event;
import io.agileintelligence.logreg.models.Messages;
import io.agileintelligence.logreg.models.User;
import io.agileintelligence.logreg.services.EventService;
import io.agileintelligence.logreg.services.UserService;
import io.agileintelligence.logreg.validator.EventValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

//    @Autowired
//    private EventValidator eventValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("")
    public String home(@Valid @ModelAttribute("event")Event event, Model model, Principal principal){
        //DRY
        String jspPage ="eventsPage";
        List<String> stateList = USStates.listOfUSStatesCode;
        Collections.sort(stateList);


        User user = userService.findByUserName(principal.getName());
        List<Event> eventsByState = eventService.eventByUserState(user);
        for(Event event1 : eventsByState){

        }
        List<Event> eventsNotInState = eventService.notInUserState(user);

        model.addAttribute("eventsByState",eventsByState);
        model.addAttribute("NotInState",eventsNotInState);
        model.addAttribute("stateList", stateList);

        return userService.CheckUserService(principal,model,jspPage);
    }

    @RequestMapping("/save")
    public String save(@Valid @ModelAttribute("event")Event event,BindingResult result,
                       @RequestParam("username")String username){
//        eventValidator.validate(event,result);
        if(result.hasErrors()){

            return "redirect:/events";
        }

        eventService.saveEvent(event, username);

        return "redirect:/events";
    }

    @RequestMapping("/{id}")
    public String showEventDetails(@Valid @ModelAttribute("messages")Messages messages, BindingResult result,
                                   @PathVariable("id")Long id, Model model, Principal principal){

        Event event = eventService.findById(id);
        User host = userService.findByUserName(event.getHost());
        User userInSession = userService.findByUserName(principal.getName());
        model.addAttribute("event", event);
        model.addAttribute("host", host);
        model.addAttribute("count", event.getUsers().size());
        model.addAttribute("userInSession", userInSession);
        model.addAttribute("messagesInEvent", event.getMessages());

        return "showEvent";

    }


    @RequestMapping("/postMessage/{id}")
    public String postMessage(@Valid @ModelAttribute("messages")Messages messages, BindingResult result,
                              @PathVariable("id")Long id){

        eventService.addMessageToEvent(id, messages);

        return "redirect:/events/"+id;
    }

    @RequestMapping("/loadEvent/{id}")
    public String loadEventForEditing(Model model, @PathVariable("id")Long id, Principal principal){

        Event eventForEdit = eventService.findById(id);
        if(!eventForEdit.getHost().equals(principal.getName()) ){
            return "redirect:/events";
        }

        List<String> stateList = USStates.listOfUSStatesCode;
        Collections.sort(stateList);
        model.addAttribute("stateList", stateList);
        model.addAttribute("event", eventForEdit);
        return "updateEvent";

    }

    @RequestMapping("/updateEvent")
    public String saveUpdatedEvent(@Valid @ModelAttribute("event")Event event, BindingResult result, @PathVariable("id")Long id){

        if(result.hasErrors()){
            return "redirect:/loadEvent/"+id;
        }

        eventService.updateEvent(event);
        return "redirect:/events";
    }

    @RequestMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable("id")Long id, Principal principal){

        Event eventForDelete = eventService.findById(id);

        if(!eventForDelete.getHost().equals(principal.getName()) ){
            return "redirect:/events";
        }
        //if not host knows url, could hack to delete himself
        eventService.deletEvent(eventForDelete);
        return "redirect:/events";

    }

    @RequestMapping("/joinEvent/{id}")
    public String joinEvent(@PathVariable("id")Long id, Principal principal, Model model){
        Event eventForJoining = eventService.findById(id);
        User userInSession = userService.findByUserName(principal.getName());
//        boolean joined = false;
        if(eventForJoining.getHost().equals(principal.getName()) || eventForJoining.getUsers().contains(userInSession)){
//            joined = true;
//            model.addAttribute("joined", joined);
            return "redirect:/events";
        }
//        model.addAttribute("joined", joined);

        eventService.addUserToEvent(eventForJoining, userInSession);
        return "redirect:/events";
    }

    @RequestMapping("/cancelAttendance/{id}")
    public String cancelAttendance(@PathVariable("id")Long id, Principal principal, Model model){
        Event eventForJoining = eventService.findById(id);
        User userInSession = userService.findByUserName(principal.getName());
//        boolean joined = true;
        if(!eventForJoining.getHost().equals(principal.getName()) && eventForJoining.getUsers().contains(userInSession)){
//            joined = false;
//            model.addAttribute("joined", joined);
            eventService.removeUserToEvent(eventForJoining,userInSession);

            return "redirect:/events";
        }
//        model.addAttribute("joined", joined);


        return "redirect:/events";

    }
}

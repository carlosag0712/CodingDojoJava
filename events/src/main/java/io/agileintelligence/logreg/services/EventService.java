package io.agileintelligence.logreg.services;

import io.agileintelligence.logreg.models.Event;
import io.agileintelligence.logreg.models.Messages;
import io.agileintelligence.logreg.models.User;
import io.agileintelligence.logreg.repositories.EventRepository;
import io.agileintelligence.logreg.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageRepository messageRepository;

    public void saveEvent(Event event, String username){
        List<User> usersInEvent =  event.getUsers();

//        usersInEvent = event.getUsers(); upon saving, the list needs to be initialized / Maybe initialize in Model?
        User userAttending = userService.findByUserName(username);
        usersInEvent.add(userAttending);
        event.setUsers(usersInEvent);

        eventRepository.save(event);

    }

    public void updateEvent(Event event){
        eventRepository.save(event);
    }

    public void deletEvent(Event event){
        eventRepository.delete(event);
    }

    public List<Event> eventByUserState(User user){

        return eventRepository.findAllByState(user.getState());
    }

    public List<Event> notInUserState(User user){
        return eventRepository.findAllByStateNot(user.getState());
    }

    public Event findById(Long id){
        return eventRepository.findById(id);
    }

    public void addUserToEvent(Event event, User userJoining) {

        List<User> usersInEvent =  event.getUsers();

        usersInEvent.add(userJoining);
        event.setUsers(usersInEvent);

        eventRepository.save(event);
    }

    public void removeUserToEvent(Event event, User userJoining) {

        List<User> usersInEvent =  event.getUsers();

        usersInEvent.remove(userJoining);
        event.setUsers(usersInEvent);

        eventRepository.save(event);
    }

    public void addMessageToEvent(Long id, Messages messages){
      Event event =  eventRepository.findById(id);
      List<Messages> messagesInEvent = event.getMessages();
      List<Event> events = messages.getEvents();
      events.add(event);
      messagesInEvent.add(messages);
      messageRepository.save(messages);


      eventRepository.save(event);

    }


//    public long countEventByUsers(){
//        return eventRepository.countEventByUsers();
//    }
}

package com.esprit.pidevbackend.Service;

import com.example.EventManage.entities.Event;
import com.example.EventManage.entities.User;
import com.example.EventManage.enumeration.Departement;
import com.example.EventManage.enumeration.Office;
import com.example.EventManage.repositories.EventRepository;
import com.example.EventManage.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Slf4j
@Transactional
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void deleteFacture(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getListEvent() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
      return   eventRepository.findById(id).orElse(null);
  }

    @Override
    public void updateEvent(Long id, Event event) {
        event = eventRepository.findById(id).orElse(null);
        eventRepository.save(event);
    }

    @Transactional
    @Override
    public void addUserToEvent(Long idUser, Long idEvent) {
        User user = userRepository.findById(idUser).orElse(null);
        Event event = eventRepository.findById(idEvent).orElse(null);
        event.getUsers().add(user);

    }

    @JsonIgnore
    @Override
    public List<User> afficherListUserByDepartment(Departement dep) {
        System.out.println("In serviceImpl +" + dep);
        return eventRepository.afficherListUserByDepartment(dep);
    }

    @Override
    public List<User> afficherListUserByOffice(Office office) {
        return eventRepository.afficherListUserByOffice(office);
    }

    @Override
    public void ModifierEvent(Event event) {
        eventRepository.save(event);

    }

    @Transactional
    @Override
    public void addEventToFavoris(Long idEvent, Long idUser) {

    }

    @Override
    public List<User> afficherParticipantByDepartement(Long idEvent, Departement departement) {
        return eventRepository.afficherParticipantByDepartement(idEvent, departement);
    }

    @Override
    public List<Event> ListEventBeforeSystemeDate(Date dateEvent) {

        return eventRepository.ListEventBeforeSystemeDate(dateEvent);
    }

    @Override
    public List<Event> selectDate() {
      //  Date date=eventRepository.dateTomorrow();
        System.out.println("tttttttttttttttttttttt"+eventRepository.dateTomorrow());
       //List<Event> events= ListEventBeforeSystemeDate(date);

        return null;
    }


    @Override
    public List<User> ListParticipantBeforeSystemDate() {
        return eventRepository.ListParticipantBeforeSystemDate();
    }

    @Override
    public List<String> ListUserByEvent(Long idEvent) {
        return eventRepository.ListUserByEvent(idEvent);
    }

}

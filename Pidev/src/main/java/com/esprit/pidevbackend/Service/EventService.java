package com.esprit.pidevbackend.Service;

import com.example.EventManage.entities.Event;
import com.example.EventManage.entities.User;
import com.example.EventManage.enumeration.Departement;
import com.example.EventManage.enumeration.Office;

import java.util.Date;
import java.util.List;

public interface EventService {

    public void addEvent(Event event);

    public void deleteFacture(Long id);

    List<Event> getListEvent();

    public Event getEventById(Long id);

    public void updateEvent(Long id, Event event);

    public void addUserToEvent(Long idUser, Long idEvent);

    List<User> afficherListUserByDepartment(Departement dep);

    List<User> afficherListUserByOffice(Office office);


    public void ModifierEvent(Event event);

    public void addEventToFavoris(Long idEvent, Long idUser);

    List<User> afficherParticipantByDepartement(Long idEvent, Departement departement);

    List<Event> ListEventBeforeSystemeDate(Date dateEvent);

    List<Event> selectDate();

    List<User> ListParticipantBeforeSystemDate();

    List<String> ListUserByEvent(Long idEvent);
}

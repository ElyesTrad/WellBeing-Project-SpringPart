package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.*;
import com.esprit.pidevbackend.Service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("addEvent")
    public void addEvent(@RequestBody Event event ) {
        eventService.addEvent(event);
    }

    @DeleteMapping("{id}")
    public void deleteFacture(@PathVariable("id") Long id) {
        eventService.deleteFacture(id);
    }

    @GetMapping("listEvent")
    public List<Event> getListEvent() {
        return eventService.getListEvent();
    }

    @GetMapping("eventById/{id}")
    @ResponseBody
    public Event getEventById(@PathVariable("id") Long id) {
        return eventService.getEventById(id);
    }

    @PutMapping("ModifierEvent/{id}")
    public void updateEvent(Long id, Event event) {
        eventService.updateEvent(id, event);
    }

    @PostMapping("userToEvent/{idUser}/{idEvent}")
    public void addUserToEvent(@PathVariable("idUser") Long idUser, @PathVariable("idEvent") Long idEvent) {
        eventService.addUserToEvent(idUser, idEvent);
    }

    @GetMapping("ListUserByDep/{dep}")
    @ResponseBody
    List<User> afficherListUserByDepartment(@PathVariable("dep") Departement dep) {
        return eventService.afficherListUserByDepartment(dep);
    }

    @GetMapping("ListUserByOff/{off}")
    public List<User> afficherListUserByOffice(@PathVariable("off") Office office) {
        return eventService.afficherListUserByOffice(office);
    }

    @PutMapping("updateEvent")
    public void ModifierEvent(Event event) {
        eventService.ModifierEvent(event);
    }

    @PostMapping("addEventToFavoris/{idEvent}/{idUser}")
    public void addEventToFavoris(@PathVariable("idEvent") Long idEvent, @PathVariable("idUser") Long idUser) {
        eventService.addEventToFavoris(idEvent, idUser);
    }

    @GetMapping("listPartByDep/{idEvent}/{dep}")
    @ResponseBody
    public List<User> afficherParticipantByDepartement(@PathVariable("idEvent") Long idEvent, @PathVariable("dep") Departement departement) {
        return eventService.afficherParticipantByDepartement(idEvent, departement);
    }

    @GetMapping("ListEventBeforeSystemeDate")
    public List<Event> ListEventBeforeSystemeDate() {
        return eventService.selectDate();
    }

    @GetMapping("ListPartByDate")
    public List<User> ListParticipantBeforeSystemDate() {
        return eventService.ListParticipantBeforeSystemDate();
    }


    @GetMapping("MailingListParticips/{idEvent}")
    public List<String> ListUserByEvent(@PathVariable("idEvent") Long idEvent) {
        return eventService.ListUserByEvent(idEvent);
    }

    @GetMapping("ListParticipantEvent/{idEvent}")
    @ResponseBody
    public List<User> ListParticipantEvent(@PathVariable("idEvent") Long idEvent) {
        return eventService.ListParticipantEvent(idEvent);
    }

    @GetMapping("getEventOneDayBefore")
    public List<Event> getEventOneDayBefore() {
        return eventService.getEventOneDayBefore();
    }


    @PostMapping("listEmail")
    public void afficherListEmail() {
        eventService.afficherListEmail();
    }


    @GetMapping("FilterByInterestCenter/{interest}")
    List<String> sendEventToUserByInterestCenter(@PathVariable("interest") IneterestCenter ineterestCenter) {
        return eventService.sendEventToUserByInterestCenter(ineterestCenter);
    }

    @PostMapping("sendMailModifie")
    public void sendEmailNotifAgent() throws MessagingException {
        eventService.sendEmailNotifAgent();
    }

    @PostMapping("PDF/{idEvent}")
    public String toPDF(@PathVariable("idEvent") Long idEvent) {
   return eventService.toPDF(idEvent);
    }

    }

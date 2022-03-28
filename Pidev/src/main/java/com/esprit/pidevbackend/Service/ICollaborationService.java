package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.*;


import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

public interface ICollaborationService {

    List<Collaboration> retrieveAllCollaborations();
    void addCollaboration(Collaboration c,long idUser);
    void deleteCollaboration(Long id);
    Collaboration updateCollaboration(Collaboration c);
    Collaboration retrieveCollaboration(Long id);

    //offer

    List<Offer> retrieveAllOffers();
    void addOffer(Offer o,long idCollaboration);
    void deleteOffer(Long id);
    Offer updateOffer(Offer o);
    Offer retrieveOffer(Long id);
    float calculProm(long idOffer);

    //publicity

    List<Publicity> retrieveAllPublicitys();
    Publicity addPublicity(Publicity p,long idOffer);
    void deletePublicity(Long id);
    Publicity updatePublicity(Publicity p);
    Publicity retrievePublicity(Long id);
    public boolean dateOffer();

    //reservation

    Reservation reservation(long idUser, long idOffer, Reservation r) throws MessagingException;
    float prixTotale ( long idReservation);
    List<Reservation> findAll();
    List<Reservation> listAll() ;

}

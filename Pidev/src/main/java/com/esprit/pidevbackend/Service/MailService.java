package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.User;

import javax.mail.MessagingException;

public interface MailService {
    public void sendEmailNotifAgent(User agent) throws MessagingException;

    public void sendEmailReservation(long idUser,long idOffer) throws MessagingException;

    public void sendRappelEmailReservation(long idReservation) throws MessagingException;



}

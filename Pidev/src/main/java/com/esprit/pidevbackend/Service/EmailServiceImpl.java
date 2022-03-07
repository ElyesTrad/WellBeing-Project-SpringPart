package com.esprit.pidevbackend.Service;

import com.example.EventManage.entities.Email;
import com.example.EventManage.entities.Event;
import com.example.EventManage.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    EventService eventService;

    @Override
    public Response sendEmail(Email mail, Long idEvent) {

        Response response = new Response();
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            List<String> listMailByEvent = eventService.ListUserByEvent(idEvent);
            Event event = eventService.getEventById(idEvent);
            for (String email : listMailByEvent) {
                message.setTo(email);
                message.setSubject("Rappel Event  " + event.getName());
                message.setText("demain vous aurez un evenement de " + event.getName());
            }


            emailSender.send(message);
            System.out.println(message);
            response.setCode(0);
            response.setMessage("Email send ok!");
        } catch (Exception ex) {
            response.setCode(1);
            response.setMessage("Error sending email: " + ex.getMessage());
        }

        return response;
    }
}

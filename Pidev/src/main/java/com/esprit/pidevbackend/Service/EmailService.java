package com.esprit.pidevbackend.Service;

import com.example.EventManage.entities.Email;
import com.example.EventManage.entities.Response;

public interface EmailService {
    Response sendEmail(Email mail, Long idEvent);
}

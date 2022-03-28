package com.esprit.pidevbackend.email;

import lombok.RequiredArgsConstructor;
import org.drools.core.io.impl.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;

@Service
@RequiredArgsConstructor
public class DefaultEmailService  {


    public JavaMailSender emailSender;

    @Async
    public void sendSimpleEmail(String toAddress, String subject, String message) {
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(toAddress);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            emailSender.send(simpleMailMessage);
        }catch(Exception e){
            throw new IllegalStateException("failed to send email");

        }

    }


    public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setTo(toAddress);
        messageHelper.setSubject(subject);
        messageHelper.setText(message);
        FileSystemResource file = new FileSystemResource(ResourceUtils.getFile(attachment));
        messageHelper.addAttachment("Purchase Order", (DataSource) file);
        emailSender.send(mimeMessage);
    }
}

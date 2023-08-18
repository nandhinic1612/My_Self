package com.SpringBoot.NotificationService.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender emailSender;
    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    public void sendNotification(String to,
                                 String subject,
                                 String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}

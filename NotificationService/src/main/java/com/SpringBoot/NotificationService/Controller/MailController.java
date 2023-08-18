package com.SpringBoot.NotificationService.Controller;

import com.SpringBoot.NotificationService.Service.MailService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MailController {

    private final MailService mailService;
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }
    @PostMapping("/send-notification")
    public String sendNotification(
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            Model model
    ) {
        mailService.sendNotification(email, subject, message);
        model.addAttribute("message", "Notification sent successfully!");
        return "notification";
    }
}

/*

Swagger url
http://localhost:8080/swagger-ui/index.html#/

enable 2step verification -> create app password -> apply it in application properties

https://www.gmass.co/smtp-test#  -- smtp test tool

mail.port -- 587
enable security -- tsl

*/
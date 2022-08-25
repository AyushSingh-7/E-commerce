package com.example.mail.service.implementation;

import com.example.mail.entity.Mail;
import com.example.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImplementation implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    @Override
    public String sendMail(Mail mail) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(mail.getRecipient());
            mailMessage.setText(mail.getMsgBody());
            mailMessage.setSubject(mail.getSubject());
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully";
        } catch (Exception e) {
            return "Error";
        }
    }
}

package com.example.mail.service;

import com.example.mail.entity.Mail;
import org.springframework.stereotype.Service;


public interface MailService {
    String sendMail(Mail mail);
}

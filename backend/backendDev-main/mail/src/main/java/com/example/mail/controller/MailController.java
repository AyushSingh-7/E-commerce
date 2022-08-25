package com.example.mail.controller;

import com.example.mail.entity.Mail;
import com.example.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/sendmail/{recipient}")
    public String sendMail(@PathVariable("recipient") String recipient)
    {
        Mail mail = new Mail();
        mail.setRecipient(recipient);
        mail.setSubject("Order Placed");
        String mailBody = "Hey!\nYour order is placed successfully. You will get your product on Time.\n\n THANKS FOR YOUR ORDER.\n VISIT US AGAIN.";
        mail.setMsgBody(mailBody);
        String status = mailService.sendMail(mail);
        return status;
    }
}

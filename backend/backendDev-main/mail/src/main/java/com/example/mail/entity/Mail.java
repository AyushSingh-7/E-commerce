package com.example.mail.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class Mail {
    private String recipient;
    private String msgBody;
    private String subject;
}

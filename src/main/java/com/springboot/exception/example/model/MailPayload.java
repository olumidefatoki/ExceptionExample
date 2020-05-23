package com.springboot.exception.example.model;

import lombok.Data;
import org.springframework.http.MediaType;

/**
 * Payload for mail sending
 */
@Data
public class MailPayload {

    private String sender;
    private String recipient;
    private String message;
    private String subject;
    private String contentType = MediaType.TEXT_HTML_VALUE;



    public MailPayload(String subject, String message, String recipient, String sender) {
        this.message = message;
        this.subject = subject;
        this.recipient = recipient;
        this.sender = sender;
    }

    public MailPayload(){
    }

}

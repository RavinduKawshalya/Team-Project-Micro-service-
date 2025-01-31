package com.example.EmailManagement.data;

import jakarta.persistence.*;

@Entity
@Table(name="emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "recipient_email",nullable = false)
    private String recipientEmail;

    @Column(name = "subject",nullable = false)
    private String subject;

    @Column(name = "message", columnDefinition = "TEXT", nullable = false)
    private String message;

    public Email() {}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getRecipientEmail() {return recipientEmail;}

    public void setRecipientEmail(String recipientEmail) {this.recipientEmail = recipientEmail;}

    public String getSubject() {return subject;}

    public void setSubject(String subject) {this.subject = subject;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

}

package com.example.EmailManagement.controller;

import com.example.EmailManagement.data.Email;
import com.example.EmailManagement.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailController {

    @Autowired

    private EmailService emailService;

    @GetMapping(path = "/emails")
    public List<Email> getEmails() {
        return emailService.getAllEmails();
    }

    @GetMapping(path="/emails/{id}")
    public Email getEmailById(@PathVariable int id){
        return emailService.getEmailById(id);
    }

    @PostMapping(path="/emails")
    public Email createEmail(@RequestBody Email email){
        return emailService.createEmail(email);
    }

    @PutMapping(path="/emails")
    public Email updateEmail(@RequestBody Email email){
        return emailService.updateEmail(email);
    }

    @DeleteMapping(path="/emails/{id}")
    public String deleteEmail(@PathVariable int id){
        return emailService.deleteEmail(id);
    }
}

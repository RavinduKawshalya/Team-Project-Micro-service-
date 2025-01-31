package com.example.EmailManagement.service;

import com.example.EmailManagement.data.Email;
import com.example.EmailManagement.data.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired

    private EmailRepository emailRepository;

    public List<Email>getAllEmails(){
        return emailRepository.findAll();
    }

    public Email getEmailById(int id) {
        Optional<Email> email = emailRepository.findById(id);
        return email.orElse(null);
    }

    public Email createEmail(Email email){
        return emailRepository.save(email);
    }

    public  Email updateEmail(Email email){
        return emailRepository.save(email);
    }

    public String deleteEmail(int id){
        emailRepository.deleteById(id);
        return "Successfully Deleted!";
    }

}

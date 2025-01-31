package com.example.EAD2.service;

import com.example.EAD2.data.Event;
import com.example.EAD2.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event getAllEventById(int id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    //insert
    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    //update
    public Event updateEvent(Event event){
        return eventRepository.save(event);
    }

    //delete
    public String deleteEvent(int id){
        eventRepository.deleteById(id);
        return "Successfully Deleted!";
    }
    public List<Event> getEventByTitle(String title){
        return eventRepository.findByProductTitle(title);
    }

    public List<Event> getEventByTitleAndLocation(String title, String location){
        return eventRepository.findByEventTitleAndLocation(title,location);
    }
}

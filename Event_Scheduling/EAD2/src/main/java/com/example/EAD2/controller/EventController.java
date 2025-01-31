package com.example.EAD2.controller;

import com.example.EAD2.data.Event;
import com.example.EAD2.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(path="/events")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping(path="/events/{id}")
    public Event getAllEventById(@PathVariable int id){
        return eventService.getAllEventById(id);
    }
    @PostMapping(path="/events")
    public Event createEvent(@RequestBody Event event){
        return eventService.createEvent(event);
    }
    @PutMapping(path="/events")
    public Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }
    @DeleteMapping(path = "/events/{id}")
    public String deleteEvent(@PathVariable int id){
        return eventService.deleteEvent(id);
    }
}

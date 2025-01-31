package com.example.Final.project.controller;

import com.example.Final.project.data.Resource;
import com.example.Final.project.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Base URL for API
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping(path="/resources/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable int id) {
        return ResponseEntity.ok(resourceService.getResourceById(id));
    }

    //Frontend connect
    @GetMapping(path="/resources")
    public ResponseEntity<List<Resource>> getAllResources() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }

    @PostMapping(path="/resources")
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        return ResponseEntity.ok(resourceService.createResource(resource));
    }

    @PutMapping(path="/resources")
    public ResponseEntity<Resource> updateResource(@RequestBody Resource resource) {
        return ResponseEntity.ok(resourceService.updateResource(resource));
    }

    @DeleteMapping(path="/resources/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable int id) {
        return ResponseEntity.ok(resourceService.deleteResource(id));
    }
}

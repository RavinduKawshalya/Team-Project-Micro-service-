package com.example.Final.project.service;

import com.example.Final.project.data.Resource;
import com.example.Final.project.data.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(int id) {
        return resourceRepository.findById(id).orElse(null);
    }

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Resource updateResource(Resource resource) {
        if (resourceRepository.existsById(resource.getId())) {
            return resourceRepository.save(resource);
        } else {
            throw new RuntimeException("Resource Not Found!");
        }
    }

    public String deleteResource(int id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
            return "Resource Deleted Successfully!";
        } else {
            return "Resource Not Found!";
        }
    }
}

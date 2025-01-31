package com.example.TaskManagement.controller;

import com.example.TaskManagement.data.Task;
import com.example.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired

    private TaskService taskService;

    @GetMapping(path = "/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(path = "/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PostMapping(path = "/tasks")
    public Task createTask(@RequestBody Task task)
    {return taskService.createTask(task);}


    @PutMapping(path = "/tasks")
    public Task updateTask(@RequestBody Task task) {
        if (task.getId() == 0) {
            throw new IllegalArgumentException("Task ID is required for updating a task.");
        }
        return taskService.updateTask(task);
    }


    @DeleteMapping(path = "/tasks/{id}")
    public String deleteTask(@PathVariable int id)
    {return taskService.deleteTask(id);}

}

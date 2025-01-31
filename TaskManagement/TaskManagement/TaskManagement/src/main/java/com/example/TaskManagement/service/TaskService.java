package com.example.TaskManagement.service;

import com.example.TaskManagement.data.Task;
import com.example.TaskManagement.data.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired

    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id){
        Optional<Task> task=taskRepository.findById(id);
        return task.orElse(null);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public  Task updateTask(Task task){
        return taskRepository.save(task);
    }


    public String deleteTask(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return "Successfully Deleted!";
        } else {
            return "Task with ID " + id + " does not exist.";
        }
    }
}

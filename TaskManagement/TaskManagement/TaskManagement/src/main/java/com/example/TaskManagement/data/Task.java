package com.example.TaskManagement.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name="task_name")
    private String taskName;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.PENDING;


    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "deadline")
    private LocalDate deadline;

    public Task() {}

    public int getId(){return id;}

    public void setId(int id){this.id=id;}

    public String getTaskName(){return taskName;}

    public void setTaskName(String taskName){this.taskName=taskName;}

    public String getAssignedTo(){return assignedTo;}

    public void setAssignedTo(String assignedTo){this.assignedTo=assignedTo;}

    public Status getStatus(){return status;}

    public void setStatus(Status status){this.status=status;}

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }


}

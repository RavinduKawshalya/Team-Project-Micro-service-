package com.example.Final.project.data;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="Resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="resource_name")
    private String resource_name;

    @Enumerated(EnumType.STRING)
    @Column(name ="resource_type")
    private ResourceType resource_type;

    @Temporal(TemporalType.DATE)
    @Column(name ="booking_date")
    private Date booking_date;

    public Resource() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public ResourceType getResource_type() {
        return resource_type;
    }

    public void setResource_type(ResourceType resource_type) {
        this.resource_type = resource_type;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }
}

// Enum Class
enum ResourceType {
    VENUE,EQUIPMENT,OTHER
}

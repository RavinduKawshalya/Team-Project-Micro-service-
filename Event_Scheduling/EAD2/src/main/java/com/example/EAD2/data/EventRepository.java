package com.example.EAD2.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    @Query("SELECT e FROM Event e WHERE e.title= ?1 AND e.location=?2")
    List<Event> findByEventTitleAndLocation(String title, String location);

    @Query("SELECT e FROM Event e WHERE e.title = ?1")
    List<Event> findByProductTitle(String title);
}

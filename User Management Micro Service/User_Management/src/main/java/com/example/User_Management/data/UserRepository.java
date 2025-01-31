package com.example.User_Management.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    List<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE u.name = :name AND u.role = :role")
    List<User> findByNameAndRole(@Param("name") String name, @Param("role") User.UserRole role);

}

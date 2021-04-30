package com.example.spring_data_test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByAgeBetween(Integer start, Integer end);

    List<User> findByAgeOrNameContainingIgnoreCase(Integer age, String name);
}

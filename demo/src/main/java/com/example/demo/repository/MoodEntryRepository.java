package com.example.demo.repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MoodEntry;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {
    // Custom method to find MoodEntries by User
    List<MoodEntry> findByUser(User user);
}

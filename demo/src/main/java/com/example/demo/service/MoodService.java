package com.example.demo.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MoodEntry;
import com.example.demo.repository.MoodEntryRepository;

@Service
public class MoodService {
    @Autowired
    private MoodEntryRepository moodRepo;

    public void saveMoodEntry(MoodEntry moodEntry) {
        moodRepo.save(moodEntry);
    }

    // Find mood entries for a specific user
    public List<MoodEntry> getMoodEntriesForUser(User user) {
        return moodRepo.findByUser(user);  // This works now
    }
}

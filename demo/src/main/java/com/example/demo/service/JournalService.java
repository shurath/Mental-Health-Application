package com.example.demo.service;



import com.example.demo.entity.JournalEntry;
import com.example.demo.repository.JournalEntryRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalEntryRepository journalRepo;

    // Save a journal entry
    public void saveJournal(String content) {
        JournalEntry entry = new JournalEntry();
        entry.setContent(content);
        journalRepo.save(entry);
    }

    // Get all journal entries
    public List<JournalEntry> getAllJournals() {
        return journalRepo.findAll();
    }

    // Delete a journal entry by ID
    public void deleteJournal(Long id) {
        journalRepo.deleteById(id);
    }
}

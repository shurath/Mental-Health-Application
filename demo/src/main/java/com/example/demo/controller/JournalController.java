package com.example.demo.controller;


import com.example.demo.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    // Display the journal form and entries
    @GetMapping
    public String showJournalPage(Model model) {
        model.addAttribute("journals", journalService.getAllJournals());
        return "journal"; // Returns 'journal.html'
    }

    // Handle adding a new journal entry
    @PostMapping("/add")
    public String addJournalEntry(@RequestParam String content) {
        journalService.saveJournal(content);
        return "redirect:/journal"; // Redirect to the journal page
    }

    // Handle deleting a journal entry
    @GetMapping("/delete/{id}")
    public String deleteJournalEntry(@PathVariable Long id) {
        journalService.deleteJournal(id);
        return "redirect:/journal"; // Redirect to the journal page after deletion
    }
}

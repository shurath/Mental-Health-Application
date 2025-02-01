package com.example.demo.controller;

import com.example.demo.entity.MoodEntry;
import com.example.demo.service.MoodService;
import com.example.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Changed to Controller from RestController
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @Autowired
    private QuoteService quoteService;

    // Display the mood tracker form and quote
    @GetMapping
    public String showMoodPage(Model model) {
        model.addAttribute("quote", quoteService.getMotivationalQuoteByMood("happy")); // Default mood can be passed
        return "mood"; // This will return the 'mood.html' view
    }

    // Handle form submission and save the mood entry
    @PostMapping("/add")
    public String addMoodEntry(@RequestParam String mood, Model model) {
        MoodEntry moodEntry = new MoodEntry();
        moodEntry.setMood(mood);  // Set the mood from the form
        moodService.saveMoodEntry(moodEntry); // Save the mood entry

        // Get the motivational quote based on the mood and pass it to the view
        model.addAttribute("quote", quoteService.getMotivationalQuoteByMood(mood));
        model.addAttribute("mood", mood); // Passing the mood to the view

        return "mood"; // Return 'mood.html' again with updated data
    }

    // Endpoint for fetching quotes by mood (optional, for debugging/testing)
    @GetMapping("/quote/{mood}")
    public String getQuoteByMood(@PathVariable String mood, Model model) {
        model.addAttribute("quote", quoteService.getMotivationalQuoteByMood(mood));
        model.addAttribute("mood", mood);
        return "mood"; // Return 'mood.html'
    }
}

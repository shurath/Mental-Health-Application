package com.example.demo.service;


import com.example.demo.repository.MotivationalQuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    @Autowired
    private MotivationalQuoteRepository quoteRepo;

    public String getMotivationalQuote() {
       return quoteRepo.findRandomQuote().getQuote();
    }
        public String getMotivationalQuoteByMood(String mood) {
            // Logic to return a quote based on mood
            switch (mood.toLowerCase()) {
                case "happy":
                    return "Keep smiling, the world needs more positivity!";
                case "sad":
                    return "Tough times don't last, but tough people do!";
                case "stressed":
                    return "Take a deep breath; you've got this!";
                default:
                    return "Stay motivated!";
            }
    }
}

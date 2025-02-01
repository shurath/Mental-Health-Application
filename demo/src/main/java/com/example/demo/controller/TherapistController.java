package com.example.demo.controller;




import com.example.demo.service.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TherapistController {

    @Autowired
    private TherapistService therapistService;

    // Import Model class from Spring
    @GetMapping("/therapists")
    public String showTherapistsPage(Model model) {
        // Fetch therapists from service and add to the model
        model.addAttribute("therapists", therapistService.getAllTherapists());
        return "therapists"; // Returns 'therapists.html' view
    }
}

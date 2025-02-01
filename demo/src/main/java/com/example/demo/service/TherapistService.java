package com.example.demo.service;
import com.example.demo.entity.Therapist;
import com.example.demo.repository.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class TherapistService {

    @Autowired
    private TherapistRepository therapistRepository;
    @GetMapping("/therapists")
    @ResponseBody
    // Method to get all therapists from the database
    public List<Therapist> getAllTherapists() {
        return therapistRepository.findAll();
    }
}

package com.project.internshipfeedback.controller;

import com.project.internshipfeedback.model.Feedback;
import com.project.internshipfeedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/feedback")
public class FeedbackController 

{

    @Autowired
    private FeedbackService service;

    @PostMapping
    public Feedback submitFeedback(@RequestBody Feedback feedback) {
        return service.saveFeedback(feedback);
 }

    @GetMapping
    public List<Feedback> getAllFeedback()
    
    {
        return service.getAllFeedbacks();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) 
    
    {
        service.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}

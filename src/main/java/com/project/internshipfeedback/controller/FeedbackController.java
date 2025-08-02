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
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    // ✅ POST feedback to: /api/feedback
    @PostMapping
    public Feedback submitFeedback(@RequestBody Feedback feedback) {
        return service.saveFeedback(feedback);
    }

    // ✅ GET all feedback from: /api/feedback
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return service.getAllFeedbacks();
    }

    // ✅ DELETE feedback by ID: /api/feedback/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        service.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}

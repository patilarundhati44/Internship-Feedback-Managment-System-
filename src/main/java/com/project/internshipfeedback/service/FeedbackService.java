package com.project.internshipfeedback.service;

import com.project.internshipfeedback.model.Feedback;
import com.project.internshipfeedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    public Feedback saveFeedback(Feedback feedback) {
        return repository.save(feedback);
    }

    public List<Feedback> getAllFeedbacks() {
        return repository.findAll();
    }

    // ✅ Add this method to support DELETE
    public void deleteFeedback(Long id) {
        repository.deleteById(id);
    }
}

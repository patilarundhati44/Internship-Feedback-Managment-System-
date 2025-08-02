package com.project.internshipfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.internshipfeedback.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>

{

}

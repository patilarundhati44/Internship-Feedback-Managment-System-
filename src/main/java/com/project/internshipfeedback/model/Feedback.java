package com.project.internshipfeedback.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String topic;
    private String feedback;
    private int rating;

    // 🆕 New fields
    private String lecturer;
    private String subject;
    private LocalDate lectureDate;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getLecturer() { return lecturer; }
    public void setLecturer(String lecturer) { this.lecturer = lecturer; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public LocalDate getLectureDate() { return lectureDate; }
    public void setLectureDate(LocalDate lectureDate) { this.lectureDate = lectureDate; }
}

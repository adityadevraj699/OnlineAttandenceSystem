package com.myproject.OnlineAttandenceSystem.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key mapping to StudentDetail's rollNo
    @ManyToOne
    @JoinColumn(name = "roll_no", referencedColumnName = "rollNo", nullable = false)
    private StudentDetail student;

    @Column(nullable = false)
    private LocalDateTime date;

    // Constructor
    public Attendance() {
        this.date = LocalDateTime.now(); // Automatically sets current date & time
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentDetail getStudent() {
        return student;
    }

    public void setStudent(StudentDetail student) {
        this.student = student;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

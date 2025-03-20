package com.example.quiz.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity() // Marks this class as a JPA entity mapped to a database table
@Table(name = "question") // Specifies the table name in the database
public class Question {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID values
    private Integer id; // Unique identifier for each question

    private String questionTitle; // Stores the actual question text

    private String option1; // Stores the first answer choice
    private String option2; // Stores the second answer choice
    private String option3; // Stores the third answer choice
    private String option4; // Stores the fourth answer choice

    private String rightAnswer; // Stores the correct answer

    private String difficultylevel; // Defines the difficulty level (e.g., easy, medium, hard)

    private String category; // Specifies the category of the question (e.g., Science, Math)
}

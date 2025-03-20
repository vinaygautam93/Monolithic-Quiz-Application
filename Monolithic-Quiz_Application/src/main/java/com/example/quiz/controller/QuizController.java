package com.example.quiz.controller;

import com.example.quiz.model.QuestionWrapper;
//import com.example.quiz.model.QuizDto;
import com.example.quiz.model.Response;
import com.example.quiz.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller
@RequestMapping("quiz") // Base URL mapping for all endpoints in this controller
public class QuizController {

    @Autowired
    QuizService quizService; // Injecting the QuizService dependency

    // Endpoint to create a new quiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQ,
                                             @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    // Endpoint to get questions for a specific quiz
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    // Endpoint to submit a quiz and calculate the score
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}

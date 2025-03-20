package com.example.quiz.controller;

import com.example.quiz.model.Question;
import com.example.quiz.model.QuestionWrapper;
import com.example.quiz.model.Response;
import com.example.quiz.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller
@RequestMapping("question") // Base URL mapping for all endpoints in this controller
public class QuestionController {

    @Autowired
    QuestionService questionService; // Injecting the QuestionService dependency

    // Endpoint to fetch all questions
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // Endpoint to fetch questions by category
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    // Endpoint to add a new question
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    // Below methods are commented out, but they are related to quiz functionality

//    // Endpoint to generate random questions for a quiz based on category and number of questions
//    @GetMapping("generate")
//    public ResponseEntity<List<Integer>> getQuestionsForQuiz
//            (@RequestParam String categoryName, @RequestParam Integer numQuestions ){
//        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
//    }
//
//    // Endpoint to fetch questions using their IDs
//    @PostMapping("getQuestions")
//    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
//        System.out.println(environment.getProperty("local.server.port")); // Prints the port number
//        return questionService.getQuestionsFromId(questionIds);
//    }
//
//    // Endpoint to calculate the quiz score based on user responses
//    @PostMapping("getScore")
//    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
//    {
//        return questionService.getScore(responses);
//    }


}

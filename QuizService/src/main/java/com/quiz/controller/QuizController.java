package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	private QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@PostMapping("/create")
	public Quiz Create (@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}
	
	@GetMapping("/getAll")
	public List<Quiz> getAll(){
		return quizService.get();
	}
	
	@GetMapping("getById/{id}")
	public Quiz getById(@PathVariable Long id){
		return quizService.getQuizById(id);
	}
	
	
}

package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.impl.QuestionServiceImpl;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionServiceImpl quesServiceImpl;
	
	@GetMapping("/")
	public List<Question> findAllQuestion(){
		return quesServiceImpl.getAllQuestion();
	}
	
	@GetMapping("/{id}")
	public Question findQuestionById(@PathVariable Long id){
		return quesServiceImpl.getQuestionById(id);
	}
	
	
	@PostMapping("/create")
	public Question createQuestion (@RequestBody Question question) {
		return quesServiceImpl.createQuestion(question);
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> findByQuizById (@PathVariable Long quizId) {
		return quesServiceImpl.findByQuizId(quizId);
		
	}
	
	
	
}

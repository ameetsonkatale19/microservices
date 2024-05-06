package com.quiz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;
	
	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}
	
	@Override
	public Quiz add(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
	
		List<Quiz> quizzes= quizRepository.findAll();
		
		List<Quiz> newQuizeList = quizzes.stream().map(quiz->{
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return 	newQuizeList;
	}

	@Override
	public Quiz getQuizById(Long id) {
		
		Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz Not Found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId())); 
		
		 return quiz;
	}


	

}

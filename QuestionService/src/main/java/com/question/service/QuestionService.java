package com.question.service;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {
	
	public List<Question> getAllQuestion();
	
	public Question getQuestionById(Long id);
	
	public Question createQuestion(Question question);
	
	public List<Question> findByQuizId(Long quizId);
}

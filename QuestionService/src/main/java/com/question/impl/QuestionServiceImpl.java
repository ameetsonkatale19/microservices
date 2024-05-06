package com.question.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	@Override
	public List<Question> getAllQuestion() {
		
		return questionRepository.findAll();
	}

	@Override
	public Question getQuestionById(Long id) {
	
		return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question Not Found"));
	}

	@Override
	public Question createQuestion(Question question) {
		
		return questionRepository.save(question);
	}

	@Override
	public List<Question> findByQuizId(Long quizId) {
		
		return questionRepository.findByQuizId(quizId);
	}

}

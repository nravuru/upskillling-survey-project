/**
 * 
 */
package com.survey.service.question;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.entity.Question;
import com.survey.repository.question.QuestionRepository;

/**
 * This is an implementation class for Question Service.
 * 
 * @author engwbsp
 *
 */

@Service
public class QuestionServiceImpl implements QuestionService {	
	
	@Autowired
	QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	public Question updateQuestion(Question question) {
		return null;
	}

	public Long deleteQuestion(Question question) {
		return null;
	}
	
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}
	
	public Question getQuestionById(Long id) {
		return null;
	}
}

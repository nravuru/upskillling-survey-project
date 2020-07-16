/**
 * 
 */
package com.survey.service.question;

import java.util.ArrayList;
import java.util.List;

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

	public Question addQuestion(Question question) {
		return null;
	}

	public Question updateQuestion(Question question) {
		return null;
	}

	public Long deleteQuestion(Question question) {
		return null;
	}
	
	public List<Question> getAllQuestions() {
		return new ArrayList();
	}
	
	public Question getQuestionById(Long id) {
		return null;
	}
}

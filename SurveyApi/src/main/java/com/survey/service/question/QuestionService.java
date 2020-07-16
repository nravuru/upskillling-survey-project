/**
 * 
 */
package com.survey.service.question;

import java.util.List;

import com.survey.entity.Question;

/**
 * This is an interface for Question Service.
 * 
 * @author engwbsp
 *
 */
public interface QuestionService {	

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Long deleteQuestion(Question question);
	
	public List<Question> getAllQuestions();
	
	public Question getQuestionById(Long id);
}

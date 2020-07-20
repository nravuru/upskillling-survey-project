/**
 * 
 */
package com.survey.service.question;

import java.util.List;
import java.util.Optional;

import com.survey.entity.Question;

/**
 * This is an interface for Question Service.
 * 
 * @author engwbsp
 *
 */
public interface QuestionService {	

	public Optional<Question> getQuestionById(Long id);

	public Question addQuestion(Question question);
	
	public List<Question> addQuestions(List<Question> questions);

	public Question updateQuestion(Question question);

	public void deleteQuestion(Question question);
	
	public void deleteQuestions();
	
	public List<Question> getAllQuestions();	
}

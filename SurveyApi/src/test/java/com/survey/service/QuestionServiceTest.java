package com.survey.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.survey.SurveyApiApplication;
import com.survey.entity.Question;
import com.survey.repository.question.QuestionRepository;
import com.survey.service.question.QuestionService;
import com.survey.service.question.QuestionServiceImpl;

/**
 * This test class contains unit tests for QuestionService implementation.
 * @author naresh.ravurumckesson.com
 *
 */
@Transactional
@SpringBootTest(classes={SurveyApiApplication.class})
public class QuestionServiceTest {

	private static final String QUESTION_TEXT1 = "Have you tried our product?";
	private static final String QUESTION_TEXT2 = "Did you like our product?";

	@Autowired
	private QuestionRepository questionRepo;
	
	@Test
	void getAllQuestions() {
		QuestionService questionSvc = new QuestionServiceImpl(questionRepo);
		questionSvc.addQuestion(new Question(QUESTION_TEXT1, "radio"));
		questionSvc.addQuestion(new Question(QUESTION_TEXT2, "radio"));

		List<Question> questions = questionSvc.getAllQuestions();
		assertEquals(questions.size(), 2);
	}
	
	@Test
	void addQuestion() {
		QuestionService questionSvc = new QuestionServiceImpl(questionRepo);
		Question question = questionSvc.addQuestion(new Question(QUESTION_TEXT1, "radio"));
		
		assertEquals(question.getQuestionText(), QUESTION_TEXT1);
	}
	
	@Test
	void updateQuestion() {
	  QuestionService questionSvc = new QuestionServiceImpl(questionRepo);
	  Question question = questionSvc.addQuestion(new Question(QUESTION_TEXT1, "radio"));
	  
	  question.setQuestionText(QUESTION_TEXT2);
	  question = questionSvc.updateQuestion(question);		 
	}
}

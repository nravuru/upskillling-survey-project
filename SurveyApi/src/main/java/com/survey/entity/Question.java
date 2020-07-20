/**
 * 
 */
package com.survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an entity class to manage the Question fields.
 * @author engwbsp
 *
 */
@Entity
@Table(name="QUESTIONS")
public class Question extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUESTION_ID")
	private Long id;
	
	@Column(name="QUESTION_TEXT")
	private String questionText;
	
	@Column(name="QUESTION_TYPE")
	private String questionType;
	
	public Question() {
			
	}
	
	public Question(String questionText, String questionType) {
		super();
		this.questionText = questionText;
		this.questionType = questionType;
	}
	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}
	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	/**
	 * @return the questionType
	 */
	public String getQuestionType() {
		return questionType;
	}
	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [Id=").append(id).append(", questionText=").append(questionText)
				.append(", questionType=").append(questionType).append("]");
		return builder.toString();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}

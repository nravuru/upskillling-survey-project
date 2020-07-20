/**
 * 
 */
package com.survey.dto;

/**
 * This is a DTO class to manage the Question fields.
 * @author engwbsp
 *
 */
public class QuestionDTO {
	
	private Long id;
	private String questionText;
	private String questionType;
	
	public QuestionDTO() {
		
	}
	
	public QuestionDTO(String questionText, String questionType) {
		super();
		this.questionText = questionText;
		this.questionType = questionType;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
		builder.append("QuestionDTO [id=").append(id).append(", questionText=").append(questionText)
				.append(", questionType=").append(questionType).append("]");
		return builder.toString();
	}

}

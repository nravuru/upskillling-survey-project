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
	
	private Long questionId;
	private String questionText;
	private Long questionType;
	
	public QuestionDTO(String questionText, Long questionType) {
		super();
		this.questionText = questionText;
		this.questionType = questionType;
	}
	
	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
	public Long getQuestionType() {
		return questionType;
	}
	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(Long questionType) {
		this.questionType = questionType;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionDTO [questionId=").append(questionId).append(", questionText=").append(questionText)
				.append(", questionType=").append(questionType).append("]");
		return builder.toString();
	}

}

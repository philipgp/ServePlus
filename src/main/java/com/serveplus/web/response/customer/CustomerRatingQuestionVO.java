package com.serveplus.web.response.customer;

public class CustomerRatingQuestionVO {
	private String questionId;
	private String question;
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerRatingQuestionVO [questionId=")
				.append(questionId).append(", question=").append(question)
				.append("]");
		return builder.toString();
	}
}

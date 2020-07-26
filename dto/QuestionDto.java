package org.covn.dto;

public class QuestionDto {

	private int questionId; 
	private String imagePath;
	private String typeOfOptions;
	private String status; 
	private String language;
	private String questionString;
	private String option1; 
	private String option2; 
	private String option3; 
	private String option4; 
	private String option5; 
	private String answerString; 
	private String additionalAttribute1;
	private String additionalAttribute2;
	
	public int getQuestionId() {
		return questionId;
	}
	public QuestionDto setQuestionId(int questionId) {
		this.questionId = questionId;
		return this;
	}
	public String getImagePath() {
		return imagePath;
	}
	public QuestionDto setImagePath(String imagePath) {
		this.imagePath = imagePath;
		return this;
	}
	public String getTypeOfOptions() {
		return typeOfOptions;
	}
	public QuestionDto setTypeOfOptions(String typeOfOptions) {
		this.typeOfOptions = typeOfOptions;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public QuestionDto setStatus(String status) {
		this.status = status;
		return this;
	}
	public String getLanguage() {
		return language;
	}
	public QuestionDto setLanguage(String language) {
		this.language = language;
		return this;
	}
	public String getQuestionString() {
		return questionString;
	}
	public QuestionDto setQuestionString(String questionString) {
		this.questionString = questionString;
		return this;
	}
	public String getOption1() {
		return option1;
	}
	public QuestionDto setOption1(String option1) {
		this.option1 = option1;
		return this;
	}
	public String getOption2() {
		return option2;
	}
	public QuestionDto setOption2(String option2) {
		this.option2 = option2;
		return this;
	}
	public String getOption3() {
		return option3;
	}
	public QuestionDto setOption3(String option3) {
		this.option3 = option3;
		return this;
	}
	public String getOption4() {
		return option4;
	}
	public QuestionDto setOption4(String option4) {
		this.option4 = option4;
		return this;
	}
	public String getOption5() {
		return option5;
	}
	public QuestionDto setOption5(String option5) {
		this.option5 = option5;
		return this;
	}
	public String getAnswerString() {
		return answerString;
	}
	public QuestionDto setAnswerString(String answerString) {
		this.answerString = answerString;
		return this;
	}
	public String getAdditionalAttribute1() {
		return additionalAttribute1;
	}
	public QuestionDto setAdditionalAttribute1(String additionalAttribute1) {
		this.additionalAttribute1 = additionalAttribute1;
		return this;
	}
	public String getAdditionalAttribute2() {
		return additionalAttribute2;
	}
	public QuestionDto setAdditionalAttribute2(String additionalAttribute2) {
		this.additionalAttribute2 = additionalAttribute2;
		return this;
	}
}

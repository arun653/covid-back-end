package org.covn.dto;

import java.util.List;

import org.covn.model.db.QuestionSet;

public class QuestionSetDto {

	private QuestionSet questionSet;
	List<QuestionCreationDto> questionCreationDtos;
	
	public QuestionSet getQuestionSet() {
		return questionSet;
	}
	public QuestionSetDto setQuestionSet(QuestionSet questionSet) {
		this.questionSet = questionSet;
		return this;
	}
	public List<QuestionCreationDto> getQuestionCreationDtos() {
		return questionCreationDtos;
	}
	public QuestionSetDto setQuestionCreationDtos(List<QuestionCreationDto> questionCreationDtos) {
		this.questionCreationDtos = questionCreationDtos;
		return this;
	}
	
}

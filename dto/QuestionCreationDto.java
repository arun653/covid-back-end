package org.covn.dto;

import java.util.List;

import org.covn.model.db.Question;
import org.covn.model.db.QuestionExt;

public class QuestionCreationDto {

	private Question question;
	private List<QuestionExt> questionExts;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<QuestionExt> getQuestionExts() {
		return questionExts;
	}
	public void setQuestionExts(List<QuestionExt> questionExts) {
		this.questionExts = questionExts;
	}
	
}

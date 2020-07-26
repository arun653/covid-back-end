package org.covn.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionSetDtoForPatient {

	private int questionSetId;
	private String questionSetName;
	private String langugae;
	private int locationId;
	private List<QuestionDto> questionDtoList = new ArrayList<QuestionDto>();
	
	public int getQuestionSetId() {
		return questionSetId;
	}
	public QuestionSetDtoForPatient setQuestionSetId(int questionSetId) {
		this.questionSetId = questionSetId;
		return this;
	}
	public String getQuestionSetName() {
		return questionSetName;
	}
	public QuestionSetDtoForPatient setQuestionSetName(String questionSetName) {
		this.questionSetName = questionSetName;
		return this;
	}
	public String getLangugae() {
		return langugae;
	}
	public QuestionSetDtoForPatient setLangugae(String langugae) {
		this.langugae = langugae;
		return this;
	}
	public int getLocationId() {
		return locationId;
	}
	public QuestionSetDtoForPatient setLocationId(int locationId) {
		this.locationId = locationId;
		return this;
	}
	public List<QuestionDto> getQuestionDtoList() {
		return questionDtoList;
	}
	public QuestionSetDtoForPatient setQuestionDtoList(List<QuestionDto> questionDtoList) {
		this.questionDtoList = questionDtoList;
		return this;
	}

}

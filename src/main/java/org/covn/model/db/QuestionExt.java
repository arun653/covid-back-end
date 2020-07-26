package org.covn.model.db;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "covid_master_questions_extension", schema = "public")
public class QuestionExt implements java.io.Serializable{

	/*@Id
	@Column(name = "question_id", nullable = false, length = 10)
	private int questionId; 
	@Column(name = "language", nullable = false, length = 5)
	private String language; 
	*/
    @EmbeddedId
    private QuestionExtIdentity questionExtIdentity;
	@Column(name = "question_string", nullable = false, length = 1000)
	private String questionString;
	@Column(name = "option1", nullable = false, length = 200)
	private String option1; 
	@Column(name = "option2", nullable = false, length = 200)
	private String option2;
	@Column(name = "option3", nullable = false, length = 200)
	private String option3; 
	@Column(name = "option4", nullable = false, length = 200)
	private String option4;
	@Column(name = "option5", nullable = false, length = 200)
	private String option5; 
	@Column(name = "answer_string", nullable = false, length = 1000)
	private String answerString; 
	@Column(name = "additional_attribute1", nullable = false, length = 500)
	private String additionalAttribute1;
	@Column(name = "additional_attribute2", nullable = false, length = 500)
	private String additionalAttribute2;
	@Column(name = "additional_attribute3", nullable = false, length = 500)
	private String additionalAttribute3;
	@Column(name = "additional_attribute4", nullable = false, length = 500)
	private String additionalAttribute4;
	@Column(name = "additional_attribute5", nullable = false, length = 500)
	private String additionalAttribute5;
	@Column(name = "created_by", nullable = false, length = 1000)
	private String createdBy; 
	@Column(name = "creation_date", nullable = false, length = 13)
	private Date creationDate; 
	@Column(name = "updated_date", nullable = false, length = 13)
	private Date updatedDate;
	
	public QuestionExt(){}
	
	public QuestionExt(/*int questionId, String language,*/QuestionExtIdentity questionExtIdentity ,String questionString, String option1, String option2,
			String option3, String option4, String option5, String answerString, String additionalAttribute1,
			String additionalAttribute2, String createdBy, Date creationDate, Date updatedDate) {
		super();
	  //  this.questionId = questionId;
		//this.language = language;
		this.questionExtIdentity=questionExtIdentity;
		this.questionString = questionString;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.option5 = option5;
		this.answerString = answerString;
		this.additionalAttribute1 = additionalAttribute1;
		this.additionalAttribute2 = additionalAttribute2;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
	}

/*	public int getQuestionId() {
		return questionId;
	}
	public QuestionExt setQuestionId(int questionId) {
		this.questionId = questionId;
		return this;
	}
	public String getLanguage() {
		return language;
	}
	public QuestionExt setLanguage(String language) {
		this.language = language;
		return this;
	}*/
	public QuestionExtIdentity getQuestionExtIdentity() {
		return questionExtIdentity;
	}

	public QuestionExt setQuestionExtIdentity(QuestionExtIdentity questionExtIdentity) {
		this.questionExtIdentity = questionExtIdentity;
		return this;
	}
	public String getQuestionString() {
		return questionString;
	}
	public QuestionExt setQuestionString(String questionString) {
		this.questionString = questionString;
		return this;
	}
	public String getOption1() {
		return option1;
	}
	public QuestionExt setOption1(String option1) {
		this.option1 = option1;
		return this;
	}
	public String getOption2() {
		return option2;
	}
	public QuestionExt setOption2(String option2) {
		this.option2 = option2;
		return this;
	}
	public String getOption3() {
		return option3;
	}
	public QuestionExt setOption3(String option3) {
		this.option3 = option3;
		return this;
	}
	public String getOption4() {
		return option4;
	}
	public QuestionExt setOption4(String option4) {
		this.option4 = option4;
		return this;
	}
	public String getOption5() {
		return option5;
	}
	public QuestionExt setOption5(String option5) {
		this.option5 = option5;
		return this;
	}
	public String getAnswerString() {
		return answerString;
	}
	public QuestionExt setAnswerString(String answerString) {
		this.answerString = answerString;
		return this;
	}
	public String getAdditionalAttribute1() {
		return additionalAttribute1;
	}
	public QuestionExt setAdditionalAttribute1(String additionalAttribute1) {
		this.additionalAttribute1 = additionalAttribute1;
		return this;
	}
	public String getAdditionalAttribute2() {
		return additionalAttribute2;
	}
	public QuestionExt setAdditionalAttribute2(String additionalAttribute2) {
		this.additionalAttribute2 = additionalAttribute2;
		return this;
	}
	public String getAdditionalAttribute3() {
		return additionalAttribute3;
	}
	public QuestionExt setAdditionalAttribute3(String additionalAttribute3) {
		this.additionalAttribute3 = additionalAttribute3;
		return this;
	}
	public String getAdditionalAttribute4() {
		return additionalAttribute4;
	}
	public QuestionExt setAdditionalAttribute4(String additionalAttribute4) {
		this.additionalAttribute4 = additionalAttribute4;
		return this;
	}
	public String getAdditionalAttribute5() {
		return additionalAttribute5;
	}
	public QuestionExt setAdditionalAttribute5(String additionalAttribute5) {
		this.additionalAttribute5 = additionalAttribute5;
		return this;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public QuestionExt setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public QuestionExt setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
		return this;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public QuestionExt setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	} 
	
}

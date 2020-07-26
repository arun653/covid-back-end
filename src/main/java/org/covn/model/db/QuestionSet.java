package org.covn.model.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.covn.model.BaseModel;

@Entity
@Table(name = "covid_questions_set", schema = "public", uniqueConstraints={@UniqueConstraint(columnNames = {"question_set_id"})
})
public class QuestionSet extends BaseModel<QuestionSet, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_set_id", nullable = false, length = 10)
	private int questionSetId;
	@Column(name = "question_set_name", nullable = true, length = 32)
	private String questionSetName;
	@Column(name = "language", nullable = true, length = 2)	
	private String language;
	@Column(name = "location_id", nullable = true, length = 10)	
	private int locationId;
	@Column(name = "no_of_questions", nullable = true, length = 10)	
	private int noOfQuestions;
	@Column(name = "list_of_question_ids", nullable = true, length = 1000)	
	private String listOfQuestionIds;
	@Column(name = "status", nullable = true, length = 2)	
	private String status;
	@Column(name = "created_by", nullable = true, length = 50)	
	private String createdBy;
	@Column(name = "creation_date", nullable = true, length = 13)
	private Date creationDate;
	@Column(name = "updated_date", nullable = true, length = 13)	
	private Date updatedDate;

	public int getQuestionSetId() {
		return questionSetId;
	}
	public QuestionSet setQuestionSetId(int questionSetId) {
		this.questionSetId = questionSetId;
		return this;
	}
	public String getQuestionSetName() {
		return questionSetName;
	}
	public QuestionSet setQuestionSetName(String questionSetName) {
		this.questionSetName = questionSetName;
		return this;
	}
	public String getLanguage() {
		return language;
	}
	public QuestionSet setLanguage(String language) {
		this.language = language;
		return this;
	}
	public int getLocationId() {
		return locationId;
	}
	public QuestionSet setLocationId(int locationId) {
		this.locationId = locationId;
		return this;
	}
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	public QuestionSet setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
		return this;
	}
	public List<Integer> getListOfQuestionIds() {
		List<Integer> questionIds = new ArrayList<Integer>();
		if(listOfQuestionIds !=null){
			String[] questions=this.listOfQuestionIds.split(",");
			for(String q:questions){questionIds.add(Integer.valueOf(q));};
		}
		return questionIds;
	}
	public QuestionSet setListOfQuestionIds(List<Integer> listOfQuestionIds) {
		this.listOfQuestionIds=""+listOfQuestionIds.get(0);
		for(int i=1;i<listOfQuestionIds.size();i++)
		{
			this.listOfQuestionIds=this.listOfQuestionIds+","+listOfQuestionIds.get(i);
		}
		return this;
	}
	public String getStatus() {
		return status;
	}
	public QuestionSet setStatus(String status) {
		this.status = status;
		return this;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public QuestionSet setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public QuestionSet setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
		return this;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public QuestionSet setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}
	public static QuestionSet of(){
		return new QuestionSet();
	}

	@Override
	public Integer getKey() {
		// TODO Auto-generated method stub
		return this.questionSetId;
	}
	@Override
	public QuestionSet copy() {
		// TODO Auto-generated method stub
		return new QuestionSet();
	}

}

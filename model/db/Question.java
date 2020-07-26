package org.covn.model.db;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.covn.model.BaseModel;

@Entity
@Table(name = "covid_master_questions", schema = "public", 
uniqueConstraints={@UniqueConstraint(columnNames = {"question_id"})
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question extends BaseModel<Question, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id", nullable = false, length = 10)
	private int questionId; 
	@Column(name = "symbolic_image_id", nullable = true, length = 10)
	private int symbolicImageId; 
	@Column(name = "type_of_options", nullable = true, length = 5)
	private String typeOfOptions; 
	@Column(name = "created_by", nullable = true, length = 50)
	private String createdBy; 
	@Column(name = "creation_date", nullable = true, length = 13)
	private Date creationDate; 
	@Column(name = "updated_date", nullable = true, length = 13)
	private Date updatedDate; 
	@Column(name = "status", nullable = true, length = 5)
	private String status; 
	@Column(name = "eligible_locations", nullable = true, length = 1000)
	private String eligibleLocations;
	
	/*@OneToMany(mappedBy="address",cascade=CascadeType.ALL)
	private List<QuestionExt> questionExts;
	public List<QuestionExt> getQuestionExts() {
		return questionExts;
	}
	public Question setQuestionExts(List<QuestionExt> questionExts) {
		this.questionExts = questionExts;
		return this;
	}
*/
	public Question(){}
	
	public Question(int symbolicImageId, String typeOfOptions, String createdBy, Date creationDate,
			Date updatedDate, String status, String eligibleLocations) {
		super();
		this.symbolicImageId = symbolicImageId;
		this.typeOfOptions = typeOfOptions;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
		this.status = status;
		this.eligibleLocations = eligibleLocations;
	}
	
	public int getQuestionId() {
		return questionId;
	}
	public Question setQuestionId(int questionId) {
		this.questionId = questionId;
		return this;
	}
	public int getSymbolicImageId() {
		return symbolicImageId;
	}
	public Question setSymbolicImageId(int symbolicImageId) {
		this.symbolicImageId = symbolicImageId;
		return this;
	}
	public String getTypeOfOptions() {
		return typeOfOptions;
	}
	public Question setTypeOfOptions(String typeOfOptions) {
		this.typeOfOptions = typeOfOptions;
		return this;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public Question setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public Question setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
		return this;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public Question setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public Question setStatus(String status) {
		this.status = status;
		return this;
	}
	public String getEligibleLocations() {
		return eligibleLocations;
	}
	public Question setEligibleLocations(String eligibleLocations) {
		this.eligibleLocations = eligibleLocations;
		return this;
	}
	@Override
	public Integer getKey() {
		// TODO Auto-generated method stub
		return this.questionId;
	}
	@Override
	public Question copy() {
		// TODO Auto-generated method stub
		return new Question();
	}
}

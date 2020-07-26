package org.covn.model.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.covn.model.BaseModel;

@Entity
@Table(name = "user_responses", schema = "public")
public class UserResponse extends BaseModel<UserResponse, UserResponseIdentity> implements java.io.Serializable{

	/*private int userId ;
	private int	questionSetId  ;*/
	
	@EmbeddedId
    private UserResponseIdentity userResponseIdentity;
	@Column(name = "location_id", nullable = false, length = 10)
	private int	locationId ;
	@Column(name = "language", nullable = false, length = 10)
	private String language ;
	@Column(name = "assessment_date", nullable = false, length = 13)
	private Date assessmentDate ;
	@Column(name = "upcoming_assessment_date", nullable = false, length = 13)
	private Date upcomingAssessmentDate ;
	@Column(name = "status", nullable = false, length = 5)
	private String status ;	
	@Column(name = "assessment_number", nullable = false, length = 10)
	private int	assessmentNumber ;
	
	public UserResponseIdentity getUserResponseIdentity() {
		return userResponseIdentity;
	}
	public UserResponse setUserResponseIdentity(UserResponseIdentity userResponseIdentity) {
		this.userResponseIdentity = userResponseIdentity;
		return this;
	}
	public int getLocationId() {
		return locationId;
	}
	public UserResponse setLocationId(int locationId) {
		this.locationId = locationId;
		return this;
	}
	public String getLanguage() {
		return language;
	}
	public UserResponse setLanguage(String language) {
		this.language = language;
		return this;
	}
	public Date getAssessmentDate() {
		return assessmentDate;
	}
	public UserResponse setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
		return this;
	}
	public Date getUpcomingAssessmentDate() {
		return upcomingAssessmentDate;
	}
	public UserResponse setUpcomingAssessmentDate(Date upcomingAssessmentDate) {
		this.upcomingAssessmentDate = upcomingAssessmentDate;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public UserResponse setStatus(String status) {
		this.status = status;
		return this;
	}
	public int getAssessmentNumber() {
		return assessmentNumber;
	}
	public UserResponse setAssessmentNumber(int assessmentNumber) {
		this.assessmentNumber = assessmentNumber;
		return this;
	}
	@Override
	public UserResponseIdentity getKey() {
		// TODO Auto-generated method stub
		return this.userResponseIdentity;
	}
	@Override
	public UserResponse copy() {
		// TODO Auto-generated method stub
		return new UserResponse();
	}
	
}

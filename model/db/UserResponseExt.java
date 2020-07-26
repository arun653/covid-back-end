package org.covn.model.db;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.covn.model.BaseModel;

@Entity
@Table(name = "user_responses_extension", schema = "public")
public class UserResponseExt extends BaseModel<UserResponseExt, UserResponseExtIdentity> implements java.io.Serializable{

/*	@Column(name = "user_id", nullable = false, length = 10)
	private int userId;
	@Column(name = "question_set_id", nullable = false, length = 10)
	private int questionSetId;
	@Column(name = "question_id", nullable = false, length = 10)
	private int questionId;*/
	
	@EmbeddedId
    private UserResponseExtIdentity userResponseExtIdentity;
	private String option1; 
	@Column(name = "option2", nullable = false, length = 200)
	private String option2;
	@Column(name = "option3", nullable = false, length = 200)
	private String option3; 
	@Column(name = "option4", nullable = false, length = 200)
	private String option4;
	@Column(name = "option5", nullable = false, length = 200)
	private String option5; 
	@Column(name = "response_given_by_user", nullable = false, length = 10)
	private String responseGivenByUser; 
	@Column(name = "correct_answer", nullable = false, length = 10)
	private String correctAnswer;
	@Column(name = "result", nullable = false, length = 5)
	private String result;
	
	/*public int getUserId() {
		return userId;
	}
	public UserResponseExt setUserId(int userId) {
		this.userId = userId;
		return this;
	}
	public int getQuestionSetId() {
		return questionSetId;
	}
	public UserResponseExt setQuestionSetId(int questionSetId) {
		this.questionSetId = questionSetId;
		return this;
	}
	public int getQuestionId() {
		return questionId;
	}
	public UserResponseExt setQuestionId(int questionId) {
		this.questionId = questionId;
		return this;
	}*/
	public UserResponseExtIdentity getUserResponseExtIdentity() {
		return userResponseExtIdentity;
	}
	public UserResponseExt setUserResponseExtIdentity(UserResponseExtIdentity userResponseExtIdentity) {
		this.userResponseExtIdentity = userResponseExtIdentity;
		return this;
	}
	
	public String getResponseGivenByUser() {
		return responseGivenByUser;
	}
	public UserResponseExt setResponseGivenByUser(String responseGivenByUser) {
		this.responseGivenByUser = responseGivenByUser;
		return this;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public UserResponseExt setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
		return this;
	}
	public String getResult() {
		return result;
	}
	public UserResponseExt setResult(String result) {
		this.result = result;
		return this;
	}
	public String getOption1() {
		return option1;
	}
	public UserResponseExt setOption1(String option1) {
		this.option1 = option1;
		return this;
	}
	public String getOption2() {
		return option2;
	}
	public UserResponseExt setOption2(String option2) {
		this.option2 = option2;
		return this;
	}
	public String getOption3() {
		return option3;
	}
	public UserResponseExt setOption3(String option3) {
		this.option3 = option3;
		return this;
	}
	public String getOption4() {
		return option4;
	}
	public UserResponseExt setOption4(String option4) {
		this.option4 = option4;
		return this;
	}
	public String getOption5() {
		return option5;
	}
	public UserResponseExt setOption5(String option5) {
		this.option5 = option5;
		return this;
	}
	@Override
	public UserResponseExtIdentity getKey() {
		// TODO Auto-generated method stub
		return this.userResponseExtIdentity;
	}
	@Override
	public UserResponseExt copy() {
		// TODO Auto-generated method stub
		return new UserResponseExt();
	}
	
}

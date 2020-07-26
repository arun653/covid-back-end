package org.covn.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserResponseExtIdentity implements Serializable {

	@Column(name = "user_id", nullable = false, length = 10)
	private int userId;
	@Column(name = "question_set_id", nullable = false, length = 10)
	private int questionSetId;
	@Column(name = "question_id", nullable = false, length = 10)
	private int questionId;
	
	public UserResponseExtIdentity(){}
	
	public UserResponseExtIdentity(int userId, int questionSetId, int questionId) {
		super();
		this.userId = userId;
		this.questionSetId = questionSetId;
		this.questionId = questionId;
	}

	public int getUserId() {
		return userId;
	}

	public UserResponseExtIdentity setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public int getQuestionSetId() {
		return questionSetId;
	}

	public UserResponseExtIdentity setQuestionSetId(int questionSetId) {
		this.questionSetId = questionSetId;
		return this;
	}

	public int getQuestionId() {
		return questionId;
	}

	public UserResponseExtIdentity setQuestionId(int questionId) {
		this.questionId = questionId;
		return this;
	}
	
	
	
}

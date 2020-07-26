package org.covn.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class UserResponseIdentity implements Serializable {

    @NotNull
    @Column(name = "user_id", nullable = false, length = 10)
	private int userId ;
    @NotNull
    @Column(name = "question_set_id", nullable = false, length = 10)
	private int	questionSetId  ;
	
    public UserResponseIdentity(){}
    
	public UserResponseIdentity(@NotNull int userId, @NotNull int questionSetId) {
		super();
		this.userId = userId;
		this.questionSetId = questionSetId;
	}

	public int getUserId() {
		return userId;
	}

	public UserResponseIdentity setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public int getQuestionSetId() {
		return questionSetId;
	}

	public UserResponseIdentity setQuestionSetId(int questionSetId) {
		this.questionSetId = questionSetId;
		return this;
	}
    
}

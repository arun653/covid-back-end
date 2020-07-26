package org.covn.model.db;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class QuestionExtIdentity implements Serializable {
    @NotNull
    @Column(name = "question_id", nullable = false, length = 10)
    private Integer questionId;

    @NotNull
    @Column(name = "language", nullable = false, length = 5)
    private String language;

    public QuestionExtIdentity() {

    }

    public QuestionExtIdentity(Integer questionId, String language) {
        this.questionId = questionId;
        this.language = language;
    }
    public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionExtIdentity that = (QuestionExtIdentity) o;

        if (questionId!=that.questionId) return false;
        return language.equals(that.language);
    }

    @Override
    public int hashCode() {
        int result = questionId.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }
}
package org.covn.repository;

import java.util.List;

import org.covn.model.db.QuestionExt;
import org.covn.model.db.QuestionExtIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionExtRepository  extends JpaRepository<QuestionExt, QuestionExtIdentity> {

	List<QuestionExt> findByQuestionExtIdentity_QuestionId(int questionId);
	
	void deleteByQuestionExtIdentity_QuestionId(List<Integer> questionIds);
}

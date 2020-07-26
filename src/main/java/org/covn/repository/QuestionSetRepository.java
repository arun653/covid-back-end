package org.covn.repository;

import java.util.List;
import java.util.Optional;

import org.covn.dto.QuestionDto;
import org.covn.model.db.QuestionSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionSetRepository extends JpaRepository<QuestionSet, Integer> {

	public Optional<QuestionSet> findByLocationIdAndLanguageAndStatus(int locationId,String language,String status);

	public List<QuestionSet> findByLocationIdAndStatus(int locationId,String status);
	
/*	@Query("	select cmq.questionId,'image_path' ,cmq.typeOfOptions,cmq.status,cmqe.language, "+
	"cmqe.questionString,cmqe.option1,cmqe.option2,cmqe.option3,cmqe.option4,cmqe.option5, "+
	"cmqe.answerString,cmqe.additionalAttribute1,cmqe.additionalAttribute2 " +
	"from Question cmq join QuestionExt cmqe "+
	"on cmq.question_id=cmqe.question_id "+
	"and cmqe.language= 'EN' "+
	"and cmq.question_id = 10")
	public List<QuestionDto> findByQuestion_LocationIdAndQuestionExt_Language(int locationId,String language);*/

}

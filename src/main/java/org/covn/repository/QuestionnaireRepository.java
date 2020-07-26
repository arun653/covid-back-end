package org.covn.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.covn.dto.QuestionCreationDto;
import org.covn.dto.QuestionDto;
import org.covn.dto.QuestionSetDto;
import org.covn.dto.QuestionSetDtoForPatient;
import org.covn.model.db.Question;
import org.covn.model.db.QuestionExt;
import org.covn.model.db.QuestionExtIdentity;
import org.covn.model.db.QuestionSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionnaireRepository {

	@Autowired
	EntityManagerFactory emf;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	QuestionExtRepository questionExtRepository;
	@Autowired
	QuestionSetRepository questionSetRepository;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// addding Question Set
	public String saveQuestionSet(QuestionSet questionSet){
		questionSet.setCreatedBy("Arun Singh").setCreationDate(new Date()).setUpdatedDate(new Date());
		String questionSetName=questionSetRepository.saveAndFlush(questionSet).getQuestionSetName();
		return questionSetName;
	}
	// updating Question Set
	public String updateQuestionSet(QuestionSet questionSet) {
		QuestionSet questionSet1=questionSetRepository.findById(questionSet.getQuestionSetId()).get();
		questionSet.setCreatedBy(questionSet1.getCreatedBy()).setCreationDate(questionSet1.getCreationDate()).setUpdatedDate(new Date());
		String questionSetName=questionSetRepository.saveAndFlush(questionSet).getQuestionSetName();
		return questionSetName;
	}
	//deleting Question Set
	public int deleteQuestionSet(int questionSetId) {
		questionSetRepository.deleteById(questionSetId);
		return questionSetId;
	}
	// getting questionset for patient
	public QuestionSetDtoForPatient fetchQuestionSetForPatient(String language) {
		// TODO Auto-generated method stub
		QuestionSetDtoForPatient questionSetDtoForPatient=new QuestionSetDtoForPatient();
		
		QuestionSet questionSet=questionSetRepository.findByLocationIdAndLanguageAndStatus(1, language, "Y").get();
		questionSetDtoForPatient.setQuestionSetId(questionSet.getQuestionSetId())
		.setQuestionSetName(questionSet.getQuestionSetName()).setLangugae(questionSet.getLanguage())
		.setLocationId(questionSet.getLocationId());

		List<Integer> questionIds=questionSet.getListOfQuestionIds();
		List<QuestionDto> questionDtos=new ArrayList<QuestionDto>();
		questionIds.forEach(questionId -> {

			Question question=questionRepository.findById(questionId).get();
			QuestionExt questionExt=questionExtRepository.findById(new QuestionExtIdentity(questionId, language)).get();
			QuestionDto questionDto=new QuestionDto();
			questionDto.setQuestionId(questionId).setAdditionalAttribute1(questionExt.getAdditionalAttribute1()).setAdditionalAttribute2(questionExt.getAdditionalAttribute2())
			.setImagePath("imagePath").setLanguage(language).setOption1(questionExt.getOption1()).setOption2(questionExt.getOption2())
			.setOption3(questionExt.getOption3()).setOption4(questionExt.getOption4()).setOption5(questionExt.getOption5())
			.setQuestionString(questionExt.getQuestionString()).setTypeOfOptions(question.getTypeOfOptions());

			questionDtos.add(questionDto);

		});

		questionSetDtoForPatient.setQuestionDtoList(questionDtos);
		return questionSetDtoForPatient;
	}

	//  getting questionset for Admin 
	public QuestionSetDto fetchQuestionSet(int questionSetId) {

		QuestionSetDto questionSetDto=new QuestionSetDto();
		QuestionSet questionSet=questionSetRepository.findById(questionSetId).get();
		List<QuestionCreationDto> questionCreationDtos=fetchQuestions(questionSet.getListOfQuestionIds());

		questionSetDto.setQuestionSet(questionSet);
		questionSetDto.setQuestionCreationDtos(questionCreationDtos);

		return questionSetDto;
	}

	//

	// Questions CRUD
	public Integer[] deleteQuestions(Integer[] questionIds) {
		List<Integer> l=Arrays.asList(questionIds);
		emf.createEntityManager();
		List<Object> queryParam = new ArrayList<>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", l);

		String sqlExt ="delete from covid_master_questions_extension cmqe where cmqe.question_id in (:ids)";
		String sql ="delete from covid_master_questions cmq where cmq.question_id in (:ids)";
		//	Query query=em.createQuery(queryString);
		queryParam.add(questionIds);
		namedParameterJdbcTemplate.update(sqlExt, parameters);
		namedParameterJdbcTemplate.update(sql, parameters);

		return questionIds;
	}

	public List<Integer> saveAllQuestions(List<QuestionCreationDto> questionCreationDtos) {

		List<Integer> questionIds=new ArrayList<Integer>();
		questionCreationDtos.forEach(questionCreationDto -> {
			Question question=questionCreationDto.getQuestion();
			question.setCreatedBy("Arun Singh").setCreationDate(new Date()).setSymbolicImageId(1).setUpdatedDate(new Date());
			int questionId=questionRepository.save(question).getQuestionId();
			questionIds.add(questionId);
			List<QuestionExt> questionExts= new ArrayList<QuestionExt>();
			questionCreationDto.getQuestionExts().forEach(questionExt -> {
				questionExts.add(questionExt.setQuestionExtIdentity(
						new QuestionExtIdentity(questionId,questionExt.getQuestionExtIdentity().getLanguage()))
						.setCreationDate(new Date())
						.setUpdatedDate(new Date()).setCreatedBy("Arun Singh"));
			});
			questionExtRepository.saveAll(questionExts);
		});

		return questionIds;
	}

	public List<Integer> updateAllQuestions(List<QuestionCreationDto> questionCreationDtos) {

		List<Integer> questionIds=new ArrayList<Integer>();
		questionCreationDtos.forEach(questionCreationDto -> {
			Question question=questionCreationDto.getQuestion();
			Question quest=questionRepository.getOne(question.getQuestionId());
			question.setCreatedBy(quest.getCreatedBy()).setCreationDate(quest.getCreationDate()).setSymbolicImageId(1)
			.setUpdatedDate(new Date());
			int questionId=questionRepository.save(question).getQuestionId();
			questionIds.add(questionId);
			List<QuestionExt> questionExts= new ArrayList<QuestionExt>();
			questionCreationDto.getQuestionExts().forEach(questionExt -> {
				QuestionExt questExt=questionExtRepository.getOne(new QuestionExtIdentity(questionId,questionExt.getQuestionExtIdentity().getLanguage()));
				questionExts.add(questionExt.setQuestionExtIdentity(
						new QuestionExtIdentity(questionId,questionExt.getQuestionExtIdentity().getLanguage()))
						.setCreationDate(questExt.getCreationDate())
						.setUpdatedDate(new Date())
						.setUpdatedDate(new Date()).setCreatedBy(questExt.getCreatedBy()));
			});
			questionExtRepository.saveAll(questionExts);
		});

		return questionIds;
	}

	public List<QuestionCreationDto> fetchQuestions(List<Integer> questionIds) {

		List<QuestionCreationDto> questionCreationDtos=new ArrayList<QuestionCreationDto>();
		questionIds.forEach(questionId ->{
			QuestionCreationDto questionCreationDto=new QuestionCreationDto();
			questionCreationDto.setQuestion(questionRepository.findById(questionId).get());
			questionCreationDto.setQuestionExts(questionExtRepository.findByQuestionExtIdentity_QuestionId(questionId));
			questionCreationDtos.add(questionCreationDto);
		});

		return questionCreationDtos;
	}
// to derive location id for fetching question set
	public String getPatientRelevantLocationId(){




		return null;
	}

}
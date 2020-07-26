package org.covn.service;

import org.covn.dto.QuestionSetDto;
import org.covn.dto.QuestionSetDtoForPatient;
import org.covn.model.db.QuestionSet;
import org.covn.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class QuestionSetService extends BaseService<QuestionSet> {

    @Autowired
    private QuestionnaireRepository repository;
    public QuestionSetService()
	{
		super(QuestionSet.class);
	}

	public String saveQuestionSet(QuestionSet questionSet){
		return repository.saveQuestionSet(questionSet);
	}
	public String updateQuestionSet(QuestionSet questionSet) {
		return repository.updateQuestionSet(questionSet);
	}
	public int deleteQuestionSet(int questionSetId) {
		return repository.deleteQuestionSet(questionSetId);
	}
	
	public QuestionSetDtoForPatient fetchQuestionSetForPatient(String language) {
		// TODO Auto-generated method stub
		return repository.fetchQuestionSetForPatient(language);
	}

	public QuestionSetDto fetchQuestionSet(int questionSetId) {
		
		return repository.fetchQuestionSet(questionSetId);
	}
	
}

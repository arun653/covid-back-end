package org.covn.service;

import java.util.List;

import org.covn.dto.QuestionCreationDto;
import org.covn.model.db.Question;
import org.covn.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class QuestionnaireService extends BaseService<Question> {

    @Autowired
    private QuestionnaireRepository repository;
	
	public QuestionnaireService()
	{
		super(Question.class);
	}
	
// for Questions CRUD Operation
	public List<Integer> saveAllQuestions(List<QuestionCreationDto> questionCreationDtos) {
		// TODO Auto-generated method stub
		return repository.saveAllQuestions(questionCreationDtos);
	}

	public List<Integer> updateAllQuestions(List<QuestionCreationDto> questionCreationDtos) {
		// TODO Auto-generated method stub
		return repository.updateAllQuestions(questionCreationDtos);
	}

	public List<QuestionCreationDto> fetchQuestions(List<Integer> questionIds) {
		// TODO Auto-generated method stub
		return repository.fetchQuestions(questionIds);
	}
	
	public Integer[] deleteQuestions(Integer[] questionIds) {
		// TODO Auto-generated method stub
		return repository.deleteQuestions(questionIds);
	}

	
}

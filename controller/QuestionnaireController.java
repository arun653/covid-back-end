package org.covn.controller;

import java.util.List;

import org.covn.dto.QuestionCreationDto;
import org.covn.dto.QuestionSetDto;
import org.covn.dto.QuestionSetDtoForPatient;
import org.covn.model.db.QuestionSet;
import org.covn.service.QuestionSetService;
import org.covn.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuestionnaireController {

	@Autowired
	QuestionSetService questionSetService;
	@Autowired
	QuestionnaireService questionnaireService;

	//
	@RequestMapping(value = "/add/questionSet", method = RequestMethod.POST)
	public String addQuestionSet(@RequestBody QuestionSet questionSet) {
		System.out.println("In addQuestionSet method using questionDto ... ");
		// new org.codehaus.jackson.map.ObjectMapper().writeValueAsString(questionSet1);
		return questionSetService.saveQuestionSet(questionSet);
	}
	
	@RequestMapping(value = "/update/questionSet", method = RequestMethod.POST)
	public String updateQuestionSet(@RequestBody QuestionSet questionSet) {
		System.out.println("In updateQuestionSet method using questionDto ... ");
		// new org.codehaus.jackson.map.ObjectMapper().writeValueAsString(questionSet1);
		return questionSetService.updateQuestionSet(questionSet);
	}
	
	@RequestMapping(value = "/delete/questionSet", method = RequestMethod.DELETE)
	public int deleteQuestionSet(@RequestParam int questionSetId) {
		System.out.println("In deleteQuestionSet method using questionDto ... ");
		// new org.codehaus.jackson.map.ObjectMapper().writeValueAsString(questionSet1);
		return questionSetService.deleteQuestionSet(questionSetId);
	}
	
	@RequestMapping(value = "/get/questionforpatient", method = RequestMethod.GET)
	public QuestionSetDtoForPatient fetchQuestionSetForPatient(/*@RequestParam int locationId,*/
			@RequestParam String language) {
		System.out.println("In fetchQuestionSetForPatient method using questionDto ... ");
		// new org.codehaus.jackson.map.ObjectMapper().writeValueAsString(questionnaireService.testQuestions(questionIds)); 
		return questionSetService.fetchQuestionSetForPatient(language);
	}
	@RequestMapping(value = "/get/questionset", method = RequestMethod.GET)
	public QuestionSetDto fetchQuestionSet(@RequestParam int questionSetId) {
		System.out.println("In fetchQuestionSet method using questionDto ... ");
		// new org.codehaus.jackson.map.ObjectMapper().writeValueAsString(questionnaireService.testQuestions(questionIds)); 
		return questionSetService.fetchQuestionSet(questionSetId);
	}
	// 
	@RequestMapping(value = "/add/question", method = RequestMethod.POST)
	public List<Integer> addQuestion(@RequestBody List<QuestionCreationDto> questionCreationDtos) {
		System.out.println("In addQuestion method using questionDto ... ");
		return questionnaireService.saveAllQuestions(questionCreationDtos);
	}
	
	@RequestMapping(value = "/update/question", method = RequestMethod.POST)
	public List<Integer> updateQuestion(@RequestBody List<QuestionCreationDto> questionCreationDtos) {   
		return questionnaireService.updateAllQuestions(questionCreationDtos);
	}

	@RequestMapping(value = "/get/question", method = RequestMethod.POST)
	public List<QuestionCreationDto> fetchQuestions(@RequestBody List<Integer> questionIds) {
		System.out.println("In fetchQuestions method using questionDto ... ");
		// new org.codehaus.jackson.map.ObjectMapper().writeValueAsString(questionnaireService.testQuestions(questionIds)); 
		return questionnaireService.fetchQuestions(questionIds);
	}
	
	@RequestMapping(value = "/delete/question", method = RequestMethod.POST)
	public Integer[] deleteQuestions(@RequestBody Integer[] questionIds) {
		System.out.println("In deleteQuestions method using questionDto ... ");
		 return questionnaireService.deleteQuestions(questionIds);
	}

}


package org.covn.controller;

import java.util.ArrayList;
import java.util.List;

import org.covn.dto.UserResponseDto;
import org.covn.model.db.UserResponse;
import org.covn.model.db.UserResponseExt;
import org.covn.model.db.UserResponseExtIdentity;
import org.covn.model.db.UserResponseIdentity;
import org.covn.service.UserResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResponseController extends BaseController{

	@Autowired
	UserResponseService userResponseService;
	
	@RequestMapping(value = "/save/userresponse", method = RequestMethod.POST)
	public boolean saveUserResponse(@RequestBody UserResponseDto userResponseDto) {
		System.out.println("In saveUserResponse method using UserResponseController ... ");
		/*UserResponseDto userResponseDto1=new UserResponseDto();
		List<UserResponseExt> userResponseExts = new ArrayList<UserResponseExt>();
		userResponseExts.add(new UserResponseExt().setUserResponseExtIdentity(new UserResponseExtIdentity()));
		UserResponse userResponse= new UserResponse().setUserResponseIdentity(new UserResponseIdentity());
		userResponseDto1.setUserResponse(userResponse).setUserResponseExts(userResponseExts);*/
		// new org.codehaus.jackson.map.ObjectMapper().writeValueAsString(userResponseDto1);
		return userResponseService.save(userResponseDto);
		// return true;
	}
	
}

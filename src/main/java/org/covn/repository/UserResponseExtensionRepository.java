package org.covn.repository;

import java.util.List;

import org.covn.dto.UserResponseDto;
import org.covn.model.db.UserResponse;
import org.covn.model.db.UserResponseExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserResponseExtensionRepository {

	@Autowired
	UserResponseRepository userResponseRepository;
	@Autowired
	UserResponseExtRepository userResponseExtRepository;
	
	public boolean save(UserResponseDto userResponseDto){
		
		UserResponse userResponse=userResponseDto.getUserResponse();
		List<UserResponseExt> userResponseExt=userResponseDto.getUserResponseExts();
		
		userResponseRepository.save(userResponse);
		userResponseExtRepository.saveAll(userResponseExt);
		
		return true;
	}
	
	
	
}

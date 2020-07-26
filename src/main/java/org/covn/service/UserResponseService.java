package org.covn.service;

import org.covn.dto.UserResponseDto;
import org.covn.model.db.UserResponse;
import org.covn.repository.UserResponseExtensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class UserResponseService extends BaseService<UserResponse> {

	@Autowired
	UserResponseExtensionRepository userResponseExtensionRepository;

	protected UserResponseService() {
		super(UserResponse.class);
	}

	public boolean save(UserResponseDto userResponseDto){
		return userResponseExtensionRepository.save(userResponseDto);
	}
}

package org.covn.dto;

import java.util.List;

import org.covn.model.db.UserResponse;
import org.covn.model.db.UserResponseExt;

public class UserResponseDto {

	private UserResponse userResponse;
	private List<UserResponseExt> userResponseExts;
	
	public UserResponse getUserResponse() {
		return userResponse;
	}
	public UserResponseDto setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
		return this;
	}
	public List<UserResponseExt> getUserResponseExts() {
		return userResponseExts;
	}
	public UserResponseDto setUserResponseExts(List<UserResponseExt> userResponseExts) {
		this.userResponseExts = userResponseExts;
		return this;
	}

}

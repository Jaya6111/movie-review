package com.ex.mreview.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.ex.mreview.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllUsersResponse extends AbstractResponse {
	private List<User> users;
	
	public AllUsersResponse(HttpStatus status, String statusCode, String message, List<User> users) {
		super(status, statusCode, message);
		this.users = users;
	}
}

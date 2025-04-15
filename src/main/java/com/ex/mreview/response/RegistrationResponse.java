package com.ex.mreview.response;

import org.springframework.http.HttpStatus;

import com.ex.mreview.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponse extends AbstractResponse {
	private User user;
	
	public RegistrationResponse(HttpStatus status, String statusCode, String message, User user) {
		super(status, statusCode, message);
		this.user = user;
	}
}

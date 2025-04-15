package com.ex.mreview.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse extends AbstractResponse {

	private String token;
	
	public LoginResponse(HttpStatus status, String statusCode, String message, String token) {
		super(status, statusCode, message);
		this.token = token;
	}
}

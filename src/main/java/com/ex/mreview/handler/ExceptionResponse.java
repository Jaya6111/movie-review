package com.ex.mreview.handler;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.ex.mreview.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse extends AbstractResponse {

	private Set<String> errorMessages;
	
	public ExceptionResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message);
		this.errorMessages = errorMessages;
	}

}

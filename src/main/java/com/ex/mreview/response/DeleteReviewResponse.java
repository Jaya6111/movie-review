package com.ex.mreview.response;

import org.springframework.http.HttpStatus;

public class DeleteReviewResponse extends AbstractResponse {

	public DeleteReviewResponse(HttpStatus status, String statusCode, String message) {
		super(status, statusCode, message);
	}
}

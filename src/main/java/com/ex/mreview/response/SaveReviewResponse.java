package com.ex.mreview.response;

import org.springframework.http.HttpStatus;

import com.ex.mreview.entity.Review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveReviewResponse extends AbstractResponse {

	private Review review;
	
	public SaveReviewResponse(HttpStatus status, String statusCode, String message, Review review) {
		super(status, statusCode, message);
		this.review = review;
	}
}

package com.ex.mreview.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.ex.mreview.entity.Review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetReviewsResponse extends AbstractResponse {

	private List<Review> reviews;
	
	public GetReviewsResponse(HttpStatus status, String statusCode, String message, List<Review> reviews) {
		super(status, statusCode, message);
		this.reviews = reviews;
	}
}

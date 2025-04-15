package com.ex.mreview.util;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.ex.mreview.entity.Review;
import com.ex.mreview.request.SaveReviewRequest;

@Component
public class ReviewUtil {

	public Review setReview(@Valid SaveReviewRequest request) {

		Review review = new Review();
		
		review.setUserId(request.getUserId());
		review.setMovieId(request.getMovieId());
		review.setRating(request.getRating());
		review.setComment(request.getComment());
		review.setCreatedAt(LocalDate.now());
		
		return review;
	}

	
}

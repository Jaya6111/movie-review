package com.ex.mreview.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ex.mreview.entity.Review;
import com.ex.mreview.repositories.ReviewRepository;
import com.ex.mreview.request.DeleteReviewRequest;
import com.ex.mreview.request.MovieReviewsRequest;
import com.ex.mreview.request.SaveReviewRequest;
import com.ex.mreview.request.UserReviewsRequest;
import com.ex.mreview.response.DeleteReviewResponse;
import com.ex.mreview.response.GetReviewsResponse;
import com.ex.mreview.response.SaveReviewResponse;
import com.ex.mreview.service.ReviewService;
import com.ex.mreview.util.ReviewUtil;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired 
	private ReviewUtil reviewUtil;
	
	@Override
	public SaveReviewResponse saveReview(@Valid SaveReviewRequest request) {
		
		Optional<Review> opRev = reviewRepository.findByUserIdAndMovieId(request.getUserId(), request.getMovieId());
		
		if(opRev.isEmpty())
			return new SaveReviewResponse(HttpStatus.PRECONDITION_FAILED, "412", "User already given review to this movie", opRev.get());
		
		Review review = reviewUtil.setReview(request);
		Review savedReview = reviewRepository.save(review);
		
		if(savedReview != null)
			return new SaveReviewResponse(HttpStatus.CREATED, "201", "Review successfully saved", savedReview);
		
		return new SaveReviewResponse(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Failed to save the review", null);
	}

	@Override
	public GetReviewsResponse getMovieReviews(@Valid MovieReviewsRequest request) {

		List<Review> reviews = reviewRepository.findByMovieId(request.getMovieId());
		
		if(reviews.isEmpty())
			return new GetReviewsResponse(HttpStatus.NOT_FOUND, "404", "reviews not found with given movie ID", Collections.emptyList());
		
		return new GetReviewsResponse(HttpStatus.OK, "200", "Reviews found with fiven movieId", reviews);
	}

	@Override
	public GetReviewsResponse getUserReviews(@Valid UserReviewsRequest request) {

		List<Review> reviews = reviewRepository.findByUserId(request.getUserId());

		if(reviews.isEmpty())
			return new GetReviewsResponse(HttpStatus.NOT_FOUND, "404", "reviews not found with given User ID", Collections.emptyList());
		
		return new GetReviewsResponse(HttpStatus.OK, "200", "Reviews found with fiven User Id", reviews);
	}

	@Override
	public DeleteReviewResponse deleteReview(@Valid DeleteReviewRequest request) {

		try {
			reviewRepository.deleteById(request.getReviewId());
			return new DeleteReviewResponse(HttpStatus.OK, "200", "Review deleted with given Id " + request.getReviewId());
		}catch (EntityNotFoundException e) {
			return new DeleteReviewResponse(HttpStatus.NOT_FOUND, "404", "Review with given Id not found to delete");
		}
	}

}

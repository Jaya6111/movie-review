package com.ex.mreview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.mreview.request.DeleteReviewRequest;
import com.ex.mreview.request.MovieReviewsRequest;
import com.ex.mreview.request.SaveReviewRequest;
import com.ex.mreview.request.UserReviewsRequest;
import com.ex.mreview.response.DeleteReviewResponse;
import com.ex.mreview.response.GetReviewsResponse;
import com.ex.mreview.response.SaveReviewResponse;
import com.ex.mreview.service.ReviewService;

@RestController
@RequestMapping("/mr/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/saveReview")
	public SaveReviewResponse saveReview(@RequestBody @Valid SaveReviewRequest request) {
		return reviewService.saveReview(request);
	}
	
	@GetMapping("/movieReviews")
	public GetReviewsResponse getMovieReviews(@RequestBody @Valid MovieReviewsRequest request) {
		return reviewService.getMovieReviews(request);
	}
	
	@GetMapping("/userReviews")
	public GetReviewsResponse getUserReviews(@RequestBody @Valid UserReviewsRequest request) {
		return reviewService.getUserReviews(request);
	}
	
	@DeleteMapping("/deleteReview")
	public DeleteReviewResponse deleteReviewResponse(@RequestBody @Valid DeleteReviewRequest request) {
		return reviewService.deleteReview(request);
	}
}

package com.ex.mreview.service;

import javax.validation.Valid;

import com.ex.mreview.request.DeleteReviewRequest;
import com.ex.mreview.request.MovieReviewsRequest;
import com.ex.mreview.request.SaveReviewRequest;
import com.ex.mreview.request.UserReviewsRequest;
import com.ex.mreview.response.DeleteReviewResponse;
import com.ex.mreview.response.GetReviewsResponse;
import com.ex.mreview.response.SaveReviewResponse;

public interface ReviewService {

	SaveReviewResponse saveReview(@Valid SaveReviewRequest request);

	GetReviewsResponse getMovieReviews(@Valid MovieReviewsRequest request);

	GetReviewsResponse getUserReviews(@Valid UserReviewsRequest request);

	DeleteReviewResponse deleteReview(@Valid DeleteReviewRequest request);

}

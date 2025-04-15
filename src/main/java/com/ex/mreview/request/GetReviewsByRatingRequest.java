package com.ex.mreview.request;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetReviewsByRatingRequest {

	@DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Rating must be at most 10")
	private float rating;
}

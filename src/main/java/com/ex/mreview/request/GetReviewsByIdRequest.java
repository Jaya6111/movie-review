package com.ex.mreview.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetReviewsByIdRequest {

	@NotNull(message = "review ID must not be null")
	@Positive(message = "review ID must be a positive number")
	private Integer reviewId;
}

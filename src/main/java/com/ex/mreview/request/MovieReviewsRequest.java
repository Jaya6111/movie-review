package com.ex.mreview.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieReviewsRequest {

	@NotNull(message = "Movie ID must not be null")
	@Positive(message = "Movie ID must be a positive number")
	private Integer movieId;
}

package com.ex.mreview.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteReviewRequest {

	@NotNull(message = "Review ID must not be null")
	@Positive(message = "Review ID must be a positive number")
	private Integer reviewId;
}

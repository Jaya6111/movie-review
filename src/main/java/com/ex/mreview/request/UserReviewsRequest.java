package com.ex.mreview.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReviewsRequest {

	@NotNull(message = "User ID must not be null")
	@Positive(message = "User ID must be a positive number")
	private Integer userId;
}

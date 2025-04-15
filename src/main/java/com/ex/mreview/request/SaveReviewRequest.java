package com.ex.mreview.request;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveReviewRequest {

	@NotNull(message = "User ID must not be null")
	@Positive(message = "User ID must be a positive number")
	private Integer userId;
	@NotNull(message = "Movie ID must not be null")
	@Positive(message = "Movie ID must be a positive number")
	private Integer movieId;
	@DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Rating must be at most 10")
    private float rating;
	@NotBlank(message = "Comment is required")
	@Size(max = 500, message = "Comment must be at most 500 characters")
	private String comment;
}

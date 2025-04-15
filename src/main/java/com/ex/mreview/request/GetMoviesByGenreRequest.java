package com.ex.mreview.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMoviesByGenreRequest {

	@NotBlank(message = "genre is required")
    private String genre;
}

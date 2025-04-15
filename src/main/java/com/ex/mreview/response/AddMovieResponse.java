package com.ex.mreview.response;

import org.springframework.http.HttpStatus;

import com.ex.mreview.entity.Movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMovieResponse extends AbstractResponse {

	private Movie movie;
	
	public AddMovieResponse(HttpStatus status, String statusCode, String message, Movie movie) {
		super(status, statusCode, message);
		this.movie = movie;
	}
}

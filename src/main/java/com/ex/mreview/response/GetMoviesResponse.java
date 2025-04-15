package com.ex.mreview.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.ex.mreview.entity.Movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMoviesResponse extends AbstractResponse {

	private List<Movie> movies;
	
	public GetMoviesResponse(HttpStatus status, String statusCode, String message, List<Movie> movies) {
		super(status, statusCode, message);
		this.movies = movies;
	}
}
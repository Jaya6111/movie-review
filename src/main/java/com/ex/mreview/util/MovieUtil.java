package com.ex.mreview.util;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.ex.mreview.entity.Movie;
import com.ex.mreview.request.AddMovieRequest;

@Component
public class MovieUtil {

	public Movie setMovie(@Valid AddMovieRequest request) {

		Movie movie = new Movie();
		
		movie.setTitle(request.getTitle());
		movie.setGenre(request.getGenre());
		movie.setReleaseDate(request.getReleaseDate());
		movie.setRating(request.getRating());
		movie.setDescription(request.getDescription());
		
		return movie;
	}

}

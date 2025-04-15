package com.ex.mreview.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ex.mreview.entity.Movie;
import com.ex.mreview.repositories.MovieRepository;
import com.ex.mreview.repositories.ReviewRepository;
import com.ex.mreview.request.AddMovieRequest;
import com.ex.mreview.request.GetMovieByIdRequest;
import com.ex.mreview.request.GetMoviesByGenreRequest;
import com.ex.mreview.response.AddMovieResponse;
import com.ex.mreview.response.GetMoviesResponse;
import com.ex.mreview.service.MovieService;
import com.ex.mreview.util.MovieUtil;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private MovieUtil movieUtil;
	
	@Override
	public AddMovieResponse addMovie(@Valid AddMovieRequest request) {

		Optional<Movie> opMovie = movieRepository.findByTitle(request.getTitle());

		if (opMovie.isPresent()) {
			return new AddMovieResponse(HttpStatus.PRECONDITION_FAILED, "412",
					"Given Title is already exists", null);
		}

		Movie movie = movieUtil.setMovie(request);

		Movie movieRes = movieRepository.save(movie);

		if (movieRes.getMovieId() > 0) {
			return new AddMovieResponse(HttpStatus.CREATED, "201", "Movie added successful", movieRes);

		} else {
			return new AddMovieResponse(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Failed to add movie", null);
		}
	}

	@Override
	public AddMovieResponse getMovieById(@Valid GetMovieByIdRequest request) {
		
		Optional<Movie> opMovie = movieRepository.findById(request.getMovieId());
		
		if(opMovie.isEmpty()) {
			return new AddMovieResponse(HttpStatus.NOT_FOUND, "404", "Movie with given Id is not found", null);
		}
		
		return new AddMovieResponse(HttpStatus.OK, "200", "Movie found successfully", opMovie.get());
	}

	@Override
	public GetMoviesResponse getMoviesByGenre(@Valid GetMoviesByGenreRequest request) {
		
		List<Movie> movies = movieRepository.findByGenre(request.getGenre());
		if(movies.isEmpty()) {
			return new GetMoviesResponse(HttpStatus.NOT_FOUND, "404", "No movies found with the given genre", Collections.emptyList());
		}
		
		return new GetMoviesResponse(HttpStatus.OK, "200", "Movies found", movies);
	}
	
	//@Scheduled(cron = "0 0 * * * *")
	@Scheduled(fixedRate = 60000) // runs every 60 seconds (adjust as needed)
    public void updateMovieRatings() {
        List<Movie> movies = movieRepository.findAll();

        for (Movie movie : movies) {
            Float avgRating = reviewRepository.findAverageRatingByMovieId(movie.getMovieId());
            movie.setRating(avgRating != null ? avgRating : 0.0f);
        }

        movieRepository.saveAll(movies);
    }

}

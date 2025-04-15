package com.ex.mreview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.mreview.request.AddMovieRequest;
import com.ex.mreview.request.GetMovieByIdRequest;
import com.ex.mreview.request.GetMoviesByGenreRequest;
import com.ex.mreview.response.AddMovieResponse;
import com.ex.mreview.response.GetMoviesResponse;
import com.ex.mreview.service.MovieService;

@RestController
@RequestMapping("/mr/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addMovie")
	public AddMovieResponse addMovie(@RequestBody @Valid AddMovieRequest request) {
		return movieService.addMovie(request);
	}
	
	@GetMapping("/getMovie")
	public AddMovieResponse getMovie(@RequestBody @Valid GetMovieByIdRequest request) {
		return movieService.getMovieById(request);
	}
	
	@GetMapping("/moviesByGenre")
	public GetMoviesResponse getMoviesByGenre(@RequestBody @Valid GetMoviesByGenreRequest request) {
		return movieService.getMoviesByGenre(request);
	}
}

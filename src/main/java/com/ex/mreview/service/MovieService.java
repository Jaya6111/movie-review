package com.ex.mreview.service;

import javax.validation.Valid;

import com.ex.mreview.request.AddMovieRequest;
import com.ex.mreview.request.GetMovieByIdRequest;
import com.ex.mreview.request.GetMoviesByGenreRequest;
import com.ex.mreview.response.AddMovieResponse;
import com.ex.mreview.response.GetMoviesResponse;

public interface MovieService {

	AddMovieResponse addMovie(@Valid AddMovieRequest request);

	AddMovieResponse getMovieById(@Valid GetMovieByIdRequest request);

	GetMoviesResponse getMoviesByGenre(@Valid GetMoviesByGenreRequest request);

}

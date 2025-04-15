package com.ex.mreview.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.mreview.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Optional<Movie> findByTitle(String title);

	List<Movie> findByGenre(String genre);

}

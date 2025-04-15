package com.ex.mreview.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ex.mreview.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	Optional<Review> findByUserIdAndMovieId(Integer userId, Integer movieId);

	List<Review> findByMovieId(Integer movieId);

	List<Review> findByUserId(Integer userId);
	
	@Query("SELECT AVG(r.rating) FROM Review r WHERE r.movieId = :movieId")
	Float findAverageRatingByMovieId(@Param("movieId") Integer movieId);


}

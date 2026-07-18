package org.example.movieproject.review.repository;

import org.example.movieproject.movie.entity.Movie;
import org.example.movieproject.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovieId(Long movieId);
}

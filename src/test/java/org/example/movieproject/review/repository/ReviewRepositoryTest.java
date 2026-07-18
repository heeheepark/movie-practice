package org.example.movieproject.review.repository;

import org.example.movieproject.movie.entity.Movie;
import org.example.movieproject.movie.repository.MovieRepository;
import org.example.movieproject.review.entity.Review;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @DisplayName("영화 ID로 리뷰를 조회한다.")
    void findByMovieId() {
        // given
        Movie movie = new Movie("아바타");
        movieRepository.save(movie);

        Review review = new Review("재밌어요", movie);
        Review saveReview = reviewRepository.save(review);

        // when
        List<Review> reviews = reviewRepository.findByMovieId(movie.getId());

        // then
        assertThat(reviews.getFirst().getId())
                .isEqualTo(saveReview.getId());
    }
}
package org.example.movieproject.review.service;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.movie.entity.Movie;
import org.example.movieproject.movie.repository.MovieRepository;
import org.example.movieproject.review.dto.ReviewCreateRequeest;
import org.example.movieproject.review.dto.ReviewCreateResponse;
import org.example.movieproject.review.entity.Review;
import org.example.movieproject.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public ReviewCreateResponse create(Long movieId, ReviewCreateRequeest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("해당 영화가 없습니다.")
        );

        Review review = new Review(request.getContent(), movie);
        Review saveReview = reviewRepository.save(review);

        return new ReviewCreateResponse(saveReview.getId(), saveReview.getContent());
    }
}

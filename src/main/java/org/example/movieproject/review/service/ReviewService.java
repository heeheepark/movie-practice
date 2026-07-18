package org.example.movieproject.review.service;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.movie.entity.Movie;
import org.example.movieproject.movie.repository.MovieRepository;
import org.example.movieproject.review.dto.*;
import org.example.movieproject.review.entity.Review;
import org.example.movieproject.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<ReviewGetResponse> getAll(Long movieId) {
        List<Review> reviews = reviewRepository.findByMovieId(movieId);
        List<ReviewGetResponse> dtos = new ArrayList<>();

        for (Review review : reviews) {
            dtos.add(new ReviewGetResponse(review.getId(), review.getContent()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public ReviewGetResponse getOne(Long movieId, Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("해당 리뷰가 없습니다.")
        );

        if (!review.getMovie().getId().equals(movieId)) {
            throw new IllegalArgumentException("해당 영화의 리뷰가 아닙니다.");
        }

        return new ReviewGetResponse(review.getId(), review.getContent());
    }

    @Transactional
    public ReviewUpdateResponse update(Long movieId, Long reviewId, ReviewUpdateRequest request) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("해당 리뷰가 없습니다.")
        );

        if (!review.getMovie().getId().equals(movieId)) {
            throw new IllegalArgumentException("해당 영화의 리뷰가 아닙니다.");
        }

        review.updateReview(request.getContent());

        return new ReviewUpdateResponse(review.getId(), review.getContent());
    }

    @Transactional
    public void delete(Long movieId, Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("해당 리뷰가 없습니다.")
        );

        if (!review.getMovie().getId().equals(movieId)) {
            throw new IllegalArgumentException("해당 영화의 리뷰가 아닙니다.");
        }

        reviewRepository.deleteById(reviewId);
    }
}

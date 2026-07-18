package org.example.movieproject.review.controller;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.review.dto.*;
import org.example.movieproject.review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<ReviewCreateResponse> create(
            @PathVariable Long movieId,
            @RequestBody ReviewCreateRequeest request
    ) {
        return ResponseEntity.ok(reviewService.create(movieId, request));
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<List<ReviewGetResponse>> getAll(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService.getAll(movieId));
    }

    @GetMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<ReviewGetResponse> getOne(
            @PathVariable Long movieId,
            @PathVariable Long reviewId
    ) {
        return ResponseEntity.ok(reviewService.getOne(movieId, reviewId));
    }

    @PutMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<ReviewUpdateResponse> update(
            @PathVariable Long movieId,
            @PathVariable Long reviewId,
            @RequestBody ReviewUpdateRequest request
    ) {
        return ResponseEntity.ok(reviewService.update(movieId, reviewId, request));
    }

    @DeleteMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<List<ReviewGetResponse>> delete(
            @PathVariable Long movieId,
            @PathVariable Long reviewId
    ) {
        reviewService.delete(movieId, reviewId);

        return ResponseEntity.ok(reviewService.getAll(movieId));
    }
}

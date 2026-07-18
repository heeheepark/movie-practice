package org.example.movieproject.review.controller;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.review.dto.ReviewCreateRequeest;
import org.example.movieproject.review.dto.ReviewCreateResponse;
import org.example.movieproject.review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

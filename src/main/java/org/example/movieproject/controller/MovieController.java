package org.example.movieproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.dto.MovieCreateRequest;
import org.example.movieproject.dto.MovieCreateResponse;
import org.example.movieproject.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<MovieCreateResponse> create(
            @RequestBody MovieCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(request));
    }
}

package org.example.movieproject.movie.controller;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.movie.dto.MovieGetResponse;
import org.example.movieproject.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/movies")
    public ResponseEntity<List<MovieGetResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAll());
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<MovieGetResponse> getOne(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getOne(movieId));
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<MovieUpdateResponse> update(
            @PathVariable Long movieId,
            @RequestBody MovieUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.update(movieId, request));
    }

    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<List<MovieGetResponse>> delete(
            @PathVariable Long movieId
    ) {
        movieService.delete(movieId);
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAll());
    }
}

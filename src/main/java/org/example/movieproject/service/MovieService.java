package org.example.movieproject.service;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.dto.MovieCreateRequest;
import org.example.movieproject.dto.MovieCreateResponse;
import org.example.movieproject.entity.Movie;
import org.example.movieproject.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public MovieCreateResponse create(MovieCreateRequest request) {
        Movie movie = new Movie(request.getTitle());
        Movie saveMovie = movieRepository.save(movie);
        return new MovieCreateResponse(saveMovie.getId(), saveMovie.getTitle());
    }
}

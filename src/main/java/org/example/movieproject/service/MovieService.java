package org.example.movieproject.service;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.dto.*;
import org.example.movieproject.entity.Movie;
import org.example.movieproject.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public MovieCreateResponse create(MovieCreateRequest request) {
        Movie movie = new Movie(request.getTitle());
        Movie saveMovie = movieRepository.save(movie);
        return new MovieCreateResponse(saveMovie.getId(), saveMovie.getTitle(), saveMovie.getCreatedAt(), saveMovie.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public List<MovieGetResponse> getAll() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieGetResponse> dtos = new ArrayList<>();

        for (Movie movie : movies) {
            dtos.add(new MovieGetResponse(movie.getId(), movie.getTitle(), movie.getCreatedAt(), movie.getModifiedAt()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public MovieGetResponse getOne(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("해당 영화가 없습니다.")
        );

        return new MovieGetResponse(movie.getId(), movie.getTitle(), movie.getCreatedAt(), movie.getModifiedAt());
    }

    @Transactional
    public MovieUpdateResponse update(Long movieId, MovieUpdateRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("해당 영화가 없습니다.")
        );

        movie.updateMovie(request.getTitle());

        return new MovieUpdateResponse(movie.getId(), movie.getTitle(), movie.getCreatedAt(), movie.getModifiedAt());
    }

    @Transactional
    public void delete(Long movieId) {
        boolean existence = movieRepository.existsById(movieId);
        if (!existence) {
            throw new IllegalArgumentException("해당 영화가 없습니다.");
        }

        movieRepository.deleteById(movieId);
    }
}

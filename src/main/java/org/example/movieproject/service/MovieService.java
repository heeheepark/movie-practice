package org.example.movieproject.service;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
}

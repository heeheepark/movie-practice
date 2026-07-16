package org.example.movieproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.movieproject.service.MovieService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
}

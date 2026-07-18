package org.example.movieproject.movie.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MovieNotFoundException extends MovieServiceException {
    public MovieNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}

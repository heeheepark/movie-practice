package org.example.movieproject.exception;

import org.example.movieproject.movie.exception.MovieServiceException;
import org.example.movieproject.review.exception.ReviewServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // MovieServiceException 커스텀 에러 핸들링
    @ExceptionHandler(MovieServiceException.class)
    public ResponseEntity<String> handleServiceException(MovieServiceException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ex.getMessage());
    }

    // ReviewServiceException 커스텀 에러 핸들링
    @ExceptionHandler(ReviewServiceException.class)
    public ResponseEntity<String> handleServiceException(ReviewServiceException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ex.getMessage());
    }
}
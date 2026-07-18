package org.example.movieproject.review.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ReviewServiceException extends RuntimeException {
    private final HttpStatus status;

    public ReviewServiceException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}

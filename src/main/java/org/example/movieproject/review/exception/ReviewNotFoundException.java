package org.example.movieproject.review.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ReviewNotFoundException extends ReviewServiceException {
    public ReviewNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}

package org.example.movieproject.review.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ReviewNotBelongToMovieException extends ReviewServiceException {
    public ReviewNotBelongToMovieException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}

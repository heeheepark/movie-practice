package org.example.movieproject.review.dto;

import lombok.Getter;

@Getter
public class ReviewCreateResponse {
    private final Long id;
    private final String content;

    public ReviewCreateResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}

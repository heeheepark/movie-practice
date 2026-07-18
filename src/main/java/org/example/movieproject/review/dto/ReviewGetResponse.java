package org.example.movieproject.review.dto;

import lombok.Getter;

@Getter
public class ReviewGetResponse {
    private final Long id;
    private final String content;

    public ReviewGetResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}

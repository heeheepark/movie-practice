package org.example.movieproject.dto;

import lombok.Getter;

@Getter
public class MovieGetResponse {
    private final Long id;
    private final String title;

    public MovieGetResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}

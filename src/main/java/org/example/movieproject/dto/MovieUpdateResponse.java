package org.example.movieproject.dto;

import lombok.Getter;

@Getter
public class MovieUpdateResponse {
    private final Long id;
    private final String title;

    public MovieUpdateResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}

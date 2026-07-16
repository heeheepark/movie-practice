package org.example.movieproject.dto;

import lombok.Getter;

@Getter
public class MovieCreateResponse {
    private final Long id;
    private final String title;

    public MovieCreateResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}

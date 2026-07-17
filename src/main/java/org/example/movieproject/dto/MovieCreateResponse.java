package org.example.movieproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MovieCreateResponse {
    private final Long id;
    private final String title;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MovieCreateResponse(Long id, String title, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

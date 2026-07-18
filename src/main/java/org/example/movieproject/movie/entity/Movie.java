package org.example.movieproject.movie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "영화 제목을 입력해주세요.")
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void updateMovie(String title) {
        this.title = title;
    }
}

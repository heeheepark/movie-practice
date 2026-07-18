package org.example.movieproject.review.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.movieproject.movie.entity.Movie;

@Entity
@Table(name = "reviews")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "리뷰 내용을 입력해주세요.")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review(String content, Movie movie) {
        this.content = content;
        this.movie = movie;
    }

    public void updateReview(String content) {
        this.content = content;
    }
}

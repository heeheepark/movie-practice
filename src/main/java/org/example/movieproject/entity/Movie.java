package org.example.movieproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
}

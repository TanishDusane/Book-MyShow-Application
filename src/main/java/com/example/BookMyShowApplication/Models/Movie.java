package com.example.BookMyShowApplication.Models;

import com.example.BookMyShowApplication.Enums.Genre;
import com.example.BookMyShowApplication.Enums.Language;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer movieId;

    @Column(unique = true)
    String movieName;

    @Enumerated(value = EnumType.STRING)
    Genre genre;

    @Enumerated(value = EnumType.STRING)
    Language language;

    double rating;
    double duration;
    LocalDate releaseDate;

}

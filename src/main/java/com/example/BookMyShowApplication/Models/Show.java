package com.example.BookMyShowApplication.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer showId;

    LocalDate showDate; //"YYYY-MM-DD"
    LocalTime showTime; //"HH:MM:SS"
    String movieName;

    @ManyToOne
    @JoinColumn
    Movie movie;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}

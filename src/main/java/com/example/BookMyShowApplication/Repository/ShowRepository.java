package com.example.BookMyShowApplication.Repository;

import com.example.BookMyShowApplication.Models.Movie;
import com.example.BookMyShowApplication.Models.Show;
import com.example.BookMyShowApplication.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {

    public Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);
}

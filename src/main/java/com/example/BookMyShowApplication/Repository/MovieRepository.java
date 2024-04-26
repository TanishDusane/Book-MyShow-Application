package com.example.BookMyShowApplication.Repository;

import com.example.BookMyShowApplication.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieName);

    @Query(value = "select * from movies where movie_name = :movieName", nativeQuery = true)
    Movie findMovie(String movieName);

}

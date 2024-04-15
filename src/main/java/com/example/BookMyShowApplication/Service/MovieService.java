package com.example.BookMyShowApplication.Service;

import com.example.BookMyShowApplication.Requests.UpdateMovieRequest;
import com.example.BookMyShowApplication.Models.Movie;
import com.example.BookMyShowApplication.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addmovie(Movie movie){
         movie  = movieRepository.save(movie);
        return "Movie has been added to database successfully: " + movie.getMovieId();
    }

    public String updateMovieAttribute(UpdateMovieRequest updateMovieRequest){
        Movie movie = movieRepository.findById(updateMovieRequest.getMovieId()).get();

        double rating = updateMovieRequest.getRating();
        double duration = updateMovieRequest.getDuration();

        movie.setDuration(duration);
        movie.setRating(rating);

        movieRepository.save(movie);

        return "Movie Attributes are updated successfully: " + movie.getMovieId() ;
    }
}

package com.example.BookMyShowApplication.Controller;

import com.example.BookMyShowApplication.Requests.UpdateMovieRequest;
import com.example.BookMyShowApplication.Models.Movie;
import com.example.BookMyShowApplication.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody Movie movie){
        String response = movieService.addmovie(movie);
        return response;
    }

    @PostMapping("/updateMovieAttributes")
    public String updateMovieAttributes(@RequestBody UpdateMovieRequest updateMovieRequest){
        String result = movieService.updateMovieAttribute(updateMovieRequest);
        return result;
    }
}

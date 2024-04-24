package com.example.BookMyShowApplication.Service;

import com.example.BookMyShowApplication.Models.Movie;
import com.example.BookMyShowApplication.Models.Show;
import com.example.BookMyShowApplication.Models.Theater;
import com.example.BookMyShowApplication.Repository.MovieRepository;
import com.example.BookMyShowApplication.Repository.ShowRepository;
import com.example.BookMyShowApplication.Repository.TheaterRepository;
import com.example.BookMyShowApplication.Requests.AddShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    public String addShow(AddShowRequest showRequest){

        Movie movie = movieRepository.findMovieByMovieName(showRequest.getMovieName());

        Show show = Show.builder().
                    showDate(showRequest.getShowDate()).
                    showTime(showRequest.getShowTime()).
                    build();

        show = showRepository.save(show);

        return "The Show has been saved to DataBase with ShowID " + show;
    }
}

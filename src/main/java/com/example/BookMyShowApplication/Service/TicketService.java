package com.example.BookMyShowApplication.Service;

import com.example.BookMyShowApplication.Models.Movie;
import com.example.BookMyShowApplication.Models.Show;
import com.example.BookMyShowApplication.Models.Theater;
import com.example.BookMyShowApplication.Repository.MovieRepository;
import com.example.BookMyShowApplication.Repository.ShowRepository;
import com.example.BookMyShowApplication.Repository.TheaterRepository;
import com.example.BookMyShowApplication.Repository.TicketRepository;
import com.example.BookMyShowApplication.Requests.bookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    public String bookTicket(bookTicketRequest bookTicketRequest){

        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(),bookTicketRequest.getShowTime(),
                movie,theater);

        Integer showId = show.getShowId();


        return "Your Ticket has been booked Successfully and ticketId is ";
    }
}

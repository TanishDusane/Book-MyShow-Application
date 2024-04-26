package com.example.BookMyShowApplication.Service;

import com.example.BookMyShowApplication.Enums.SeatType;
import com.example.BookMyShowApplication.Models.Movie;
import com.example.BookMyShowApplication.Models.Show;
import com.example.BookMyShowApplication.Models.ShowSeat;
import com.example.BookMyShowApplication.Models.Theater;
import com.example.BookMyShowApplication.Models.TheaterSeat;
import com.example.BookMyShowApplication.Repository.MovieRepository;
import com.example.BookMyShowApplication.Repository.ShowRepository;
import com.example.BookMyShowApplication.Repository.ShowSeatRepository;
import com.example.BookMyShowApplication.Repository.TheaterRepository;
import com.example.BookMyShowApplication.Requests.AddShowRequest;
import com.example.BookMyShowApplication.Requests.AddShowSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String addShow(AddShowRequest showRequest){

        Movie movie = movieRepository.findById(showRequest.getMovieId()).get();
        Theater theater = theaterRepository.findById(showRequest.getTheaterId()).get();

        Show show = Show.builder().
                    showDate(showRequest.getShowDate()).
                    showTime(showRequest.getShowTime()).
                    movie(movie).
                    movieName(movie.getMovieName()).
                    theater(theater).
                    build();

        show = showRepository.save(show);

        return "The Show has been saved to DataBase with ShowID " + show.getShowId();
    }

    public String addShowSeats(AddShowSeatsRequest showSeatsRequest){

        Integer showId = showSeatsRequest.getShowId();
        Show show = showRepository.findById(showId).get();

        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatsList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatsList = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatsList){
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(Boolean.TRUE)
                    .show(show)
                    .build();

            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showSeatsRequest.getPriceOfClassicSeats());
            } else if (theaterSeat.getSeatType().equals(SeatType.PRIME)) {
                showSeat.setPrice(showSeatsRequest.getPriceOfPrimeSeats());
            } else {
                showSeat.setPrice(showSeatsRequest.getPriceOfReclinerSeats());
            }

            showSeatsList.add(showSeat);
        }

        showSeatRepository.saveAll(showSeatsList);

        return "Show Seats have been generated for the given showId";
    }
}

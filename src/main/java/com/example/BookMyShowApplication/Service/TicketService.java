package com.example.BookMyShowApplication.Service;

import com.example.BookMyShowApplication.Exceptions.SeatUnavailableException;
import com.example.BookMyShowApplication.Models.*;
import com.example.BookMyShowApplication.Repository.*;
import com.example.BookMyShowApplication.Requests.bookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    public Ticket bookTicket(bookTicketRequest bookTicketRequest) throws Exception {

        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());

        Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(),
                    bookTicketRequest.getShowTime(),movie,theater);

        Integer showId = show.getShowId();

        List<ShowSeat> showSeatList = showSeatRepository.findShowSeats(showId);

        int totalAmount = 0;
        Boolean areAllSeatsAvilable = Boolean.TRUE;

        for(String seatNo : bookTicketRequest.getRequestedSeats()){
            for(ShowSeat showSeat : showSeatList){
                if(showSeat.getSeatNo().equals(seatNo)){
                    if(showSeat.getIsAvailable() == Boolean.FALSE){
                        areAllSeatsAvilable = Boolean.FALSE;
                        break;
                    }
                    totalAmount = totalAmount + showSeat.getPrice();
                }
            }
        }

        if(areAllSeatsAvilable == Boolean.FALSE){
            throw new SeatUnavailableException("The requested seats are unavailable");
        }

        for(String seatNo : bookTicketRequest.getRequestedSeats()){
            for(ShowSeat showSeat : showSeatList){
                if(showSeat.getSeatNo().equals(seatNo)){
                    showSeat.setIsAvailable(Boolean.FALSE);
                }
            }
        }

        User user = userRepository.findUserByMobNo(bookTicketRequest.getMobNo());

        Ticket ticket = Ticket.builder().user(user)
                        .movieName(bookTicketRequest.getMovieName())
                        .showDate(bookTicketRequest.getShowDate())
                        .theaterNameAddress(theater.getName() + " " + theater.getAddress())
                        .showTime(bookTicketRequest.getShowTime())
                        .totalAmountPaid(totalAmount)
                        .build();

        ticket = ticketRepository.save(ticket);

        return ticket;
    }
}

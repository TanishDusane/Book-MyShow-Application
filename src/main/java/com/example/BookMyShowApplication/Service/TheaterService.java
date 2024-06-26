package com.example.BookMyShowApplication.Service;

import com.example.BookMyShowApplication.Enums.SeatType;
import com.example.BookMyShowApplication.Models.Theater;
import com.example.BookMyShowApplication.Models.TheaterSeat;
import com.example.BookMyShowApplication.Repository.TheaterRepository;
import com.example.BookMyShowApplication.Repository.TheaterSeatsRepository;
import com.example.BookMyShowApplication.Requests.AddTheaterRequest;
import com.example.BookMyShowApplication.Requests.AddTheaterSeats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatsRepository theaterSeatsRepository;

    public String addTheater(@RequestBody AddTheaterRequest addTheaterRequest){

        Theater theater = Theater.builder()
                .address(addTheaterRequest.getAddress())
                .noOfScreens(addTheaterRequest.getNoOfScreens())
                .name(addTheaterRequest.getName())
                .build();

        theaterRepository.save(theater);

        return "Theater has been added successfully: " + theater.getTheaterId();
    }

    public String addTheaterSeats(@RequestBody AddTheaterSeats addTheaterSeats){

        int noOfClassicSeats = addTheaterSeats.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterSeats.getNoOfPremiumSeats();
        int noOfReclinerSeats = addTheaterSeats.getNoOfRecliner();

        Integer theaterId = addTheaterSeats.getTheaterId();
        Theater theater = theaterRepository.findById(theaterId).get();

        int classSeatCounter = 1, rowNo = 1;
        char ch = 'A';

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        while(classSeatCounter <= noOfClassicSeats){
            String seatNo = rowNo + "" + ch;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                                      .seatNo(seatNo)
                                      .seatType(SeatType.CLASSIC)
                                      .theater(theater)
                                      .build();

            theaterSeatList.add(theaterSeat);
            ch++;

            if(classSeatCounter%5 == 0){
                rowNo = rowNo+1;
                ch = 'A';
            }
            classSeatCounter++;
        }

        int PremiumSeatCounter = 1;
        ch = 'A';

        if(classSeatCounter%5 != 1){
            rowNo = rowNo+1;
        }

        while(PremiumSeatCounter <= noOfPremiumSeats){
            String seatNo = rowNo + "" + ch;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                                    .seatNo(seatNo)
                                    .seatType(SeatType.PRIME)
                                    .theater(theater)
                                    .build();

            theaterSeatList.add(theaterSeat);
            ch++;

            if(PremiumSeatCounter % 5 == 0){
                rowNo = rowNo+1;
                ch = 'A';
            }
            PremiumSeatCounter++;
        }

        int ReclinerSeatCounter = 1;
        ch = 'A';

        if(PremiumSeatCounter%5 != 1){
            rowNo = rowNo+1;
        }

        while(ReclinerSeatCounter <= noOfReclinerSeats){
            String seatNo = rowNo + "" + ch;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                                    .seatNo(seatNo)
                                    .seatType(SeatType.RECLINER)
                                    .theater(theater)
                                    .build();

            theaterSeatList.add(theaterSeat);
            ch++;

            if(ReclinerSeatCounter % 5 == 0){
                rowNo = rowNo+1;
                ch = 'A';
            }
            ReclinerSeatCounter++;
        }

        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);
        return "Theater seats has been created successfully";
    }
}

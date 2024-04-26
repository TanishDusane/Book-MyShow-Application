package com.example.BookMyShowApplication.Requests;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class bookTicketRequest {

    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private List<String> requestedSeats;
    private Integer theaterId;
    private String mobNo;
}

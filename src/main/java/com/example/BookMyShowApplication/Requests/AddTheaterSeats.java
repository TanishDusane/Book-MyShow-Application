package com.example.BookMyShowApplication.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterSeats {

    private int noOfClassicSeats;
    private int noOfPremiumSeats;
    private int theaterId;
    private int noOfRecliner;
}

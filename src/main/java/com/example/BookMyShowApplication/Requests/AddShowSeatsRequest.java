package com.example.BookMyShowApplication.Requests;

import lombok.Data;

@Data
public class AddShowSeatsRequest {

    private Integer showId;
    private Integer priceOfClassicSeats;
    private Integer priceOfPrimeSeats;
    private Integer priceOfReclinerSeats;

}

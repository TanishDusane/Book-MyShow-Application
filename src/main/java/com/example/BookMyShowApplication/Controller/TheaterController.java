package com.example.BookMyShowApplication.Controller;

import com.example.BookMyShowApplication.Requests.AddTheaterRequest;
import com.example.BookMyShowApplication.Requests.AddTheaterSeats;
import com.example.BookMyShowApplication.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheater")
    public String addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        String result = theaterService.addTheater(addTheaterRequest);
        return result;
    }

    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterSeats addTheaterSeats){
        String answer = theaterService.addTheaterSeats(addTheaterSeats);
        return answer;
    }
}

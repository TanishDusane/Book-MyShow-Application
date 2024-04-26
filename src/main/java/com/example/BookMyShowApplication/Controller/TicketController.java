package com.example.BookMyShowApplication.Controller;

import com.example.BookMyShowApplication.Models.Ticket;
import com.example.BookMyShowApplication.Requests.bookTicketRequest;
import com.example.BookMyShowApplication.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("bookTicket")
    public String bookTicket(@RequestBody bookTicketRequest bookTicketRequest){
        String response = ticketService.bookTicket(bookTicketRequest);
        return response;
    }
}

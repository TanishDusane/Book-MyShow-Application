package com.example.BookMyShowApplication.Repository;

import com.example.BookMyShowApplication.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,String> {

}

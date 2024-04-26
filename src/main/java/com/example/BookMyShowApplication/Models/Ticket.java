package com.example.BookMyShowApplication.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String ticketId;

    String movieName;
    LocalDate showDate;
    LocalTime showTime;
    String theaterNameAddress;
    Integer totalAmountPaid;

    @ManyToOne
    @JoinColumn
    private User user;
}

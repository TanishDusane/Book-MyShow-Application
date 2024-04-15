package com.example.BookMyShowApplication.Models;

import com.example.BookMyShowApplication.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "theaterSeat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer theaterSeatId;

    String seatNo;

    @Enumerated(EnumType.STRING)
    SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theater theater;
}

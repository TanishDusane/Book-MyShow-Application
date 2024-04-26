package com.example.BookMyShowApplication.Models;

import com.example.BookMyShowApplication.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "shows_seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer showSeatId;

    String seatNo;

    @Enumerated(value = EnumType.STRING)
    SeatType seatType;

    Integer price;
    Boolean isAvailable;

    @ManyToOne
    @JoinColumn
    private Show show;
}

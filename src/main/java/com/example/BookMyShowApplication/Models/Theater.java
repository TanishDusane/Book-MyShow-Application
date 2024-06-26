package com.example.BookMyShowApplication.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer theaterId;

    Integer noOfScreens;
    String name;
    String address;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<TheaterSeat> theaterSeatList = new ArrayList<>();
}

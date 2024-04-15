package com.example.BookMyShowApplication.Repository;

import com.example.BookMyShowApplication.Models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatsRepository extends JpaRepository<TheaterSeat, Integer> {
}

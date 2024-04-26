package com.example.BookMyShowApplication.Repository;

import com.example.BookMyShowApplication.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {

}

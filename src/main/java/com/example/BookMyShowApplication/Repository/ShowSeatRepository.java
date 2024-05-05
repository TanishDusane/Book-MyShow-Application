package com.example.BookMyShowApplication.Repository;

import com.example.BookMyShowApplication.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {

 //   public List<ShowSeat> findAllByShow(Integer show); //Inbuilt method

    //custom JPA query
    @Query(nativeQuery = true, value = "select * from shows_seats where show_show_id = :showId")
    public List<ShowSeat> findShowSeats(Integer showId);

}

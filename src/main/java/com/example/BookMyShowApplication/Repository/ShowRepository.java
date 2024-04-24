package com.example.BookMyShowApplication.Repository;

import com.example.BookMyShowApplication.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {

}

package com.example.BookMyShowApplication.Repository;

import com.example.BookMyShowApplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findUserByMobNo(String mobNo);
}

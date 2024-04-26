package com.example.BookMyShowApplication.Service;

import com.example.BookMyShowApplication.Models.User;
import com.example.BookMyShowApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(User user){
        user = userRepository.save(user);
        return "The User has been saved to DataBase sucessfully with UserId " + user.getUserId();
    }
}

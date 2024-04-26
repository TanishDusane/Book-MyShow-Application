package com.example.BookMyShowApplication.Controller;

import com.example.BookMyShowApplication.Models.User;
import com.example.BookMyShowApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("adduser")
    public String addUser(@RequestBody User user){
        String response = userService.addUser(user);
        return response;
    }
}

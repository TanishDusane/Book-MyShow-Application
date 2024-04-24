package com.example.BookMyShowApplication.Controller;

import com.example.BookMyShowApplication.Requests.AddShowRequest;
import com.example.BookMyShowApplication.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody AddShowRequest showRequest){
        String result = showService.addShow(showRequest);
        return result;
    }
}

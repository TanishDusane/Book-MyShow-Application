package com.example.BookMyShowApplication.Service;

import com.example.BookMyShowApplication.Models.User;
import com.example.BookMyShowApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String addUser(User user){
        user = userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Welcome to BookMyShow! Enjoy a Special Discount on Your First Movie \uD83C\uDFAC");
        message.setFrom("demoaccc21@gmail.com");
        message.setTo(user.getEmailId());

        String body = "Dear " + user.getName() + "!\n\n"
                + "Welcome to BookMyShow, your ultimate destination for all things entertainment! We're thrilled to have you join our community."
                + "\n\n" + "As a token of our appreciation, we're delighted to offer you a special flat discount of ₹100 on your first movie booking with us! " +
                "Whether it's the latest blockbuster or a classic favorite, we hope this discount enhances your movie-watching experience with us."
                +"\n\n" + "To avail of this offer, simply use the promo code **WELCOME100** during checkout when booking your first movie ticket with BookMyShow."
                +"\n\n" + "But wait, there's more! In addition to the discount, here are some highlights of what you can expect from your BookMyShow experience:\n" +
                "\n" + "* Access to a wide range of movies, events, plays, and more, all at your fingertips.\n" +
                "* Seamless booking process with secure payment options for a hassle-free experience.\n" +
                "* Personalized recommendations tailored to your preferences, ensuring you never miss out on the entertainment you love.\n\n\n" +
                "Thank you once again for choosing BookMyShow. We can't wait to help you create unforgettable memories with every movie ticket booked!\n" +
                "\n" + "\n" +
                "See you at the movies!"
                + "\n" + "\n" + "\n\n" +
                "Best regards,\n" +
                "BookMyShow Team";

        message.setText(body);

        javaMailSender.send(message);

        return "The User has been saved to DataBase sucessfully with UserId " + user.getUserId();
    }
}
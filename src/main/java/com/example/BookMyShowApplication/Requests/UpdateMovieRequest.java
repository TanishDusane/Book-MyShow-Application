package com.example.BookMyShowApplication.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMovieRequest {

        private Integer movieId;
        private double rating;
        private double duration;
}
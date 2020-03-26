package com.de.ratingdataservice.resource;

import com.de.ratingdataservice.model.Rating;
import com.de.ratingdataservice.model.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") Integer movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") Integer userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating(1234, 4),
                new Rating(9876, 3)
        );
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }

}

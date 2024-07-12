package com.example.MovieWatcher.controllers;

import com.example.MovieWatcher.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/movies/popular")
    public String getPopularMovies() {
        return movieService.getPopularMovies();
    }
}
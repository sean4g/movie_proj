package com.MovieWatcher.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MovieWatcher.service.MovieService;

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
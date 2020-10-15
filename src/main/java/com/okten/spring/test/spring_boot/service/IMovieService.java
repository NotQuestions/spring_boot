package com.okten.spring.test.spring_boot.service;

import com.okten.spring.test.spring_boot.entity.Movie;

import java.util.List;

public interface IMovieService {

    Movie insertMovie(Movie movie);
    
    List<Movie> getAllMovies();
    
    Movie getMovie(int id);
    
    Movie updateMovie(Movie movie);

    void remove(int id);
    
    

}

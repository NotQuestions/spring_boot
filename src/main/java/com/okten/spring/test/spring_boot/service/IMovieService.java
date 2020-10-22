package com.okten.spring.test.spring_boot.service;

import com.okten.spring.test.spring_boot.dto.MovieDTO;
import com.okten.spring.test.spring_boot.dto.MoviePageDTO;
import com.okten.spring.test.spring_boot.entity.Movie;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IMovieService {

    MovieDTO insertMovie(Movie movie, int directorId);
    
    MoviePageDTO getAllMovies(PageRequest pageRequest);
    
    Movie getMovie(int id);
    
    Movie updateMovie(Movie movie);

    void remove(int id);


    List<Movie> getMoviesByDirectorName(String name);
}

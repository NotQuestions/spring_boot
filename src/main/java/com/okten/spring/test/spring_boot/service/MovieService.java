package com.okten.spring.test.spring_boot.service;

import com.okten.spring.test.spring_boot.dao.MovieDao;
import com.okten.spring.test.spring_boot.entity.Movie;
import com.okten.spring.test.spring_boot.exception.CapitalLetterException;
import com.okten.spring.test.spring_boot.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie insertMovie(Movie movie) {
        String firstSymbol = movie.getTitle().substring(0,1);
        if (!firstSymbol.equals(firstSymbol.toUpperCase()) || firstSymbol.matches("[-+]?\\d+")){
            throw  new CapitalLetterException("Title should start with capital letter");
        }
        return movieDao.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Movie getMovie(int id) {
        return movieDao.findById(id).orElseThrow(()-> new RuntimeException("Not found movie"));
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public void remove(int id) {
        movieDao.deleteById(id);
    }
}

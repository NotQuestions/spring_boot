package com.okten.spring.test.spring_boot.service.impl;

import com.okten.spring.test.spring_boot.dao.DirectorDao;
import com.okten.spring.test.spring_boot.dao.MovieDao;
import com.okten.spring.test.spring_boot.dto.MovieDTO;
import com.okten.spring.test.spring_boot.dto.MoviePageDTO;
import com.okten.spring.test.spring_boot.entity.Director;
import com.okten.spring.test.spring_boot.entity.Movie;
import com.okten.spring.test.spring_boot.exception.CapitalLetterException;
import com.okten.spring.test.spring_boot.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private DirectorDao directorDao;

    @Override
    public MovieDTO insertMovie(Movie movie, int directorId) {
        String firstSymbol = movie.getTitle().substring(0,1);
        if (!firstSymbol.equals(firstSymbol.toUpperCase()) || firstSymbol.matches("[-+]?\\d+")){
            throw  new CapitalLetterException("Title should start with capital letter");
        }
        final Director director = directorDao.getOne(directorId);
        movie.setDirector(director);
         movie = movieDao.save(movie);
        return new MovieDTO(movie.getId(), movie.getTitle(), movie.getDuration(), director.getName());
    }

    @Override
    public MoviePageDTO getAllMovies(PageRequest pageRequest) {
        Page<Movie> all = movieDao.findAll(pageRequest);
        return new MoviePageDTO(all.getContent(), all.getTotalElements(), all.getSize(), all.isEmpty());
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

    @Override
    public List<Movie> getMoviesByDirectorName(String name) {
        return movieDao.findByDirectorName(name);
    }
}

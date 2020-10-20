package com.okten.spring.test.spring_boot.controller;

import com.okten.spring.test.spring_boot.entity.Movie;
import com.okten.spring.test.spring_boot.service.IMovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j

public class MovieController {

    private IMovieService movieService;
//    @Autowired
//    private MovieValidator movieValidator;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovie(id);
        //        return movieDao.findById(id).orElseThrow(() -> new RuntimeException("No movie with id"));
    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie insertMovie(@RequestBody @Valid Movie movie) {
        log.info("Handling Post /movie with object: " + movie);
        return movieService.insertMovie(movie);
    }

    @PutMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie updateMovie(@PathVariable int id, @Valid @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.insertMovie(movie);
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id) {
        movieService.remove(id);
    }

//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder){
////    webDataBinder.addValidators(new MovieValidator());
//    webDataBinder.addValidators(movieValidator);
//    }
}

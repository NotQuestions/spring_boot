package com.okten.spring.test.spring_boot.controller;

import com.okten.spring.test.spring_boot.dto.MovieDTO;
import com.okten.spring.test.spring_boot.dto.MoviePageDTO;
import com.okten.spring.test.spring_boot.entity.Movie;
import com.okten.spring.test.spring_boot.service.IMovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/movies")
public class MovieController {

    private IMovieService movieService;
//    @Autowired
//    private MovieValidator movieValidator;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public MoviePageDTO getMovies(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "3") int size) {
        final PageRequest pageRequest = PageRequest.of(page, size);
        return movieService.getAllMovies(pageRequest);
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovie(id);
        //        return movieDao.findById(id).orElseThrow(() -> new RuntimeException("No movie with id"));
    }


    @GetMapping("/name/{name}")
    public List<Movie> getMovies(@PathVariable String name) {
        return movieService.getMoviesByDirectorName(name);
        //        return movieDao.findById(id).orElseThrow(() -> new RuntimeException("No movie with id"));
    }

    @PostMapping("/directors/{directorId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO insertMovie(@RequestBody @Valid Movie movie, @PathVariable int directorId) {
        log.info("Handling Post /movie with object: " + movie);
        return movieService.insertMovie(movie, directorId);
    }

//    @PutMapping("/movies/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Movie updateMovie(@PathVariable int id, @Valid @RequestBody Movie movie) {
//        movie.setId(id);
//        return movieService.insertMovie(movie, id);
//    }

    @DeleteMapping("/{id}")
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

package com.okten.spring.test.spring_boot.controller;

import com.okten.spring.test.spring_boot.entity.Director;
import com.okten.spring.test.spring_boot.service.IDirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/directors")
public class DirectorController {

    private IDirectorService directorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Director saveDirector(@RequestBody Director director){

        return directorService.save(director);
    }

    @GetMapping
    public List<Director> getAllDirectors() {
        return  directorService.getDirectors();
    }

    @GetMapping("/{name}")
    public Director getDirectorByName(@PathVariable String name) {
        return directorService.getDirectorByName(name);
    }
}

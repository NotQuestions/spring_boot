package com.okten.spring.test.spring_boot.dto;

import com.okten.spring.test.spring_boot.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MoviePageDTO {

    private List<Movie> movies;
    private long totalElement;
    private int size;
    private boolean empty;
}

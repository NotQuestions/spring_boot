package com.okten.spring.test.spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MovieDTO {
    private  int movieId;
    private  String title;
    private  int duration;
    private  String ditectorName;
}

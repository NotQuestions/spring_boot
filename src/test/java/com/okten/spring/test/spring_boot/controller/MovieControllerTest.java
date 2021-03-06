package com.okten.spring.test.spring_boot.controller;


import com.okten.spring.test.spring_boot.entity.Movie;
import com.okten.spring.test.spring_boot.service.impl.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MovieControllerTest.class)
public class MovieControllerTest {

    @MockBean
    private MovieService movieService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenMovieIdWhenGettingMovieReturnSuccessfulResponse() throws Exception {
        BDDMockito.given(movieService.getMovie(ArgumentMatchers.anyInt()))
                .willReturn(new Movie(1, "TEXT", 132, null));

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }



}

package com.okten.spring.test.spring_boot.dao;

import com.okten.spring.test.spring_boot.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface MovieDao extends JpaRepository<Movie, Integer> {
    @Query("SELECT  m FROM Movie m WHERE m.title =: title")
    Movie findByTitle(String title);
}

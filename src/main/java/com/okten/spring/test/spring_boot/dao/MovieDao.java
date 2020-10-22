package com.okten.spring.test.spring_boot.dao;

import com.okten.spring.test.spring_boot.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;


public interface MovieDao extends JpaRepository<Movie, Integer> {
    @Query("select m from Movie m where m.title=:title")
    Movie findByTitle(String title);

    @Query("select m from Movie m join m.director d where d.name=:name")
    List<Movie> findByDirectorName(String name);
}

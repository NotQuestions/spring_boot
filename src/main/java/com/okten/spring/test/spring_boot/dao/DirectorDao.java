package com.okten.spring.test.spring_boot.dao;

import com.okten.spring.test.spring_boot.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DirectorDao extends JpaRepository <Director, Integer> {

    @Query("select d from Director  d join fetch d.movies where d.name=:name")
    Director findByName(String name);
}

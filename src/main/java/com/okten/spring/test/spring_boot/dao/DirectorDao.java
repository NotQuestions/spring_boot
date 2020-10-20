package com.okten.spring.test.spring_boot.dao;

import com.okten.spring.test.spring_boot.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorDao extends JpaRepository <Director, Integer> {
}

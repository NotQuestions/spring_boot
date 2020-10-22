package com.okten.spring.test.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handle", "fieldHandler"})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 270)
    @NotBlank
    private String title;
    @Positive
    @Max(200)
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Director director;
}

package com.okten.spring.test.spring_boot.validator;


import com.okten.spring.test.spring_boot.entity.Movie;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MovieValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Movie.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie = (Movie) o;
        if (movie.getTitle() != null && movie.getTitle().trim().length() > 0) {
            String firstSymbol = movie.getTitle().substring(0, 1);
            if (!firstSymbol.equals(firstSymbol.toUpperCase()) || firstSymbol.matches("[-+]?\\d+")) {
                errors.rejectValue("title", "movie.title.capital-letter", "Title must start with capital letter");
            }
        }
    }
}

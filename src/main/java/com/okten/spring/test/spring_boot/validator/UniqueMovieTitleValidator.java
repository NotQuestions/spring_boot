package com.okten.spring.test.spring_boot.validator;
import com.okten.spring.test.spring_boot.dao.MovieDao;
import com.okten.spring.test.spring_boot.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

public class UniqueMovieTitleValidator implements ConstraintValidator<UniqueMovieTitle, String> {
    private MovieDao movieDao;
    public UniqueMovieTitleValidator(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public void initialize(UniqueMovieTitle constraint) {
    }

    public boolean isValid(String title, ConstraintValidatorContext context) {
        if (title != null && title.length() != 0) {
            Movie movie = movieDao.findByTitle(title);
            return movie == null;
        }
        return false;
    }
}

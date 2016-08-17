package com.twu.biblioteca;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

public class MovieTest {
    String name = "Titanic";
    String year = "1997";
    String director = "James Cameron";
    String rating = "9";

    Movie titanicMovie = new Movie(name, year, director, rating);

    @Test
    public void should_return_name_of_movie_when_call_getter_name_method() {
        assertEquals("getter method should have the same name with the name of movie", "Titanic", titanicMovie.getName());
    }

    @Test
    public void should_have_name_year_director_and_rating_as_a_detail_of_movie() {
        String movieDetail = titanicMovie.getDetail();
        assertThat("detail of movie should contain the name of movie", movieDetail, containsString("Titanic"));
        assertThat("detail of movie should contain the year of movie", movieDetail, containsString("1997"));
        assertThat("detail of movie should contain the director of movie", movieDetail, containsString("James Cameron"));
        assertThat("detail of movie should contain the rating of movie", movieDetail, containsString("9"));

    }

    @Test
    public void should_be_able_to_check_out_when_instantiate_object() {
        assertTrue("the movie should be able to check out after object was created", titanicMovie.checkOut());
    }

    @Test
    public void should_not_be_able_to_check_out_when_movie_is_not_available() {
        titanicMovie.checkOut();
        assertFalse("the movie should not be able to check out again when it is not available", titanicMovie.checkOut());
    }

    @Test
    public void should_have_header_of_detail_when_call_getter_detail_of_movie()  {

        assertThat("header should have name", titanicMovie.getHeaderOfDetail(), containsString("Name"));
        assertThat("header should have year", titanicMovie.getHeaderOfDetail(), containsString("Year"));
        assertThat("header should have director", titanicMovie.getHeaderOfDetail(), containsString("Director"));
        assertThat("header should have rating", titanicMovie.getHeaderOfDetail(), containsString("Rating"));
    }
}

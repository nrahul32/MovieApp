package com.nrahul32.movieapp.services;

import com.nrahul32.movieapp.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    public Movie acceptMovieDetails(Movie movie);
    public Movie getMovieDetails(int id);
    public Movie updateMovieDetails(int id, Movie movie);
    public List<Movie> getAllMovies();
    public Page<Movie> getPaginatedMovieDetails(Pageable pageRequest);
    public boolean deleteMovie(int id);
    public List<Movie> AcceptMultipleMovieDetails(List<Movie> movies);

}

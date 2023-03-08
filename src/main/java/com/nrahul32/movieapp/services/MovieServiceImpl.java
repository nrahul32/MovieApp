package com.nrahul32.movieapp.services;

import com.nrahul32.movieapp.dao.MovieDao;
import com.nrahul32.movieapp.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieServiceImpl implements MovieService{

    @Autowired
    public MovieDao _movieDao;
    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return _movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) {
        return _movieDao.findById(id).get();
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) {
        Movie savedMovie = getMovieDetails(movie.getMovieId());
        savedMovie.setMovieName(movie.getMovieName());
        savedMovie.setMovieDescription(movie.getMovieDescription());
        savedMovie.setDuration(movie.getDuration());
        savedMovie.setTrailerUrl(movie.getTrailerUrl());
        savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        savedMovie.setReleaseDate(movie.getReleaseDate());
        return _movieDao.save(savedMovie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return _movieDao.findAll();
    }

    @Override
    public Page<Movie> getPaginatedMovieDetails(Pageable pageRequest) {
        return _movieDao.findAll(pageRequest);
    }

    @Override
    public boolean deleteMovie(int id) {
        Movie savedMovie = getMovieDetails(id);

        if(savedMovie == null){
            return false;
        }
        _movieDao.delete(savedMovie);
        return true;
    }

    // All movies will not be actually inserted in the DB until all the movies are ready to be stored
    @Override
    @Transactional
    public List<Movie> AcceptMultipleMovieDetails(List<Movie> movies) {
        List<Movie> savedMovies = new ArrayList<>();
        for(Movie movie : movies) {
            savedMovies.add(acceptMovieDetails(movie));
        }
        return savedMovies;
    }
}

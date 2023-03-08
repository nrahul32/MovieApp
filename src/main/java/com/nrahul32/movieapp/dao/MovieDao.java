package com.nrahul32.movieapp.dao;

import com.nrahul32.movieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This layer will be used to talk to the database
 */
public interface MovieDao extends JpaRepository<Movie, Integer> {
}

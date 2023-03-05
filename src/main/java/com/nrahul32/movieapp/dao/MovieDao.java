package com.nrahul32.movieapp.dao;

import com.nrahul32.movieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Integer> {
}

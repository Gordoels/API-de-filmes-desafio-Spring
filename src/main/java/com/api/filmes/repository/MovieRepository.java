package com.api.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.filmes.model.Movie;
import com.api.filmes.repository.movie.MovieRepositoryQuery;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryQuery {
	
}

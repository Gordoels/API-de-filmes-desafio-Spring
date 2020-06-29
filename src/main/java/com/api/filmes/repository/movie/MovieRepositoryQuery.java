package com.api.filmes.repository.movie;

import java.util.List;

import com.api.filmes.model.Movie;
import com.api.filmes.repository.filter.MovieFilter;

public interface MovieRepositoryQuery {

	public List<Movie> movieFiltrator(MovieFilter movieFilter);
}

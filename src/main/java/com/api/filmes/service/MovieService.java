package com.api.filmes.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.filmes.model.Movie;
import com.api.filmes.repository.MovieRepository;
import com.api.filmes.repository.filter.MovieFilter;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepo;
	
	
	public Movie updateMovie(Long id, Movie movie) {
		Movie savedMovie = findMovieById(id);
		BeanUtils.copyProperties(movie, savedMovie, "id");
		
		return movieRepo.save(savedMovie);
	}

	public void updateTitleProperty(Long id, String title) {
		Movie savedMovie = findMovieById(id);
		savedMovie.setTitle(title);
		
		movieRepo.save(savedMovie);
	}

	public Movie findMovieById(Long id) {
		Optional<Movie> savedMovie = movieRepo.findById(id);
		
		if(!savedMovie.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedMovie.get();
	}

	public void deleteMovieById(Long id) {
		movieRepo.deleteById(id);
	}

	public Movie createMovie(@Valid Movie movie) {
		return movieRepo.save(movie);
	}

	public List<Movie> findAllMovies(MovieFilter movieFilter) {
		return movieRepo.movieFiltrator(movieFilter);
	}
}

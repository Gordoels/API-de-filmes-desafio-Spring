package com.api.filmes.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.filmes.model.Movie;
import com.api.filmes.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepo;
	
	
	public Movie updateMovie(Long id, Movie movie) {
		Movie savedMovie = findMovieById(id);
		BeanUtils.copyProperties(movie, savedMovie, "id");
		
		return movieRepo.save(savedMovie);
	}

	public void updateAdultProperty(Long id, Boolean adult) {
		Movie savedMovie = findMovieById(id);
		savedMovie.setAdult(adult);
		
		movieRepo.save(savedMovie);
	}

	private Movie findMovieById(Long id) {
		Optional<Movie> savedMovie = movieRepo.findById(id);
		if(!savedMovie.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedMovie.get();
	}
}

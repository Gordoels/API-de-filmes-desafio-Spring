package com.api.filmes.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.filmes.model.Movie;
import com.api.filmes.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Autowired
	MovieRepository movieRepo;
	
	
	@GetMapping
	public List<Movie> findAll(){
		return movieRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Movie findById(@PathVariable Long id) {
		Optional<Movie> movie = movieRepo.findById(id);

		if(!movie.isPresent()) {
			throw new IllegalArgumentException();
		}
		return movie.get();
	}
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie, HttpServletResponse response) {
		Movie savedMovie = movieRepo.save(movie);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedMovie.getId()).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(savedMovie);
	}
}

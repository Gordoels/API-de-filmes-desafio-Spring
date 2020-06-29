package com.api.filmes.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.filmes.event.EventResourceCreated;
import com.api.filmes.model.Movie;
import com.api.filmes.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public List<Movie> findAllMovies(){
		return movieService.findAllMovies();
	}
	
	@GetMapping("/{id}")
	public Movie findMovieById(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);

		return movie;
	}
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie, HttpServletResponse response) {
		Movie savedMovie = movieService.createMovie(movie);
		
		publisher.publishEvent(new EventResourceCreated(this, response, savedMovie.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeMovie(@PathVariable Long id) {
		movieService.deleteMovieById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@Valid @RequestBody Movie movie) {
		Movie savedMovie = movieService.updateMovie(id, movie);
		
		return ResponseEntity.ok(savedMovie);
	}
	
	@PutMapping("/{id}/title")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateTitleProperty(@PathVariable Long id,@Valid @RequestBody String title) {
		movieService.updateTitleProperty(id, title);
	}
}

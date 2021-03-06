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
import com.api.filmes.model.Genre;
import com.api.filmes.service.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreResource {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public List<Genre> findAllGenre(){
		return genreService.findAllGenre();
	}
	
	@GetMapping("/{id}")
	public Genre findGenreById(@PathVariable Long id) {
		Genre genre = genreService.findGenreById(id);

		return genre;
	}
	
	@PostMapping
	public ResponseEntity<Genre> createGenre(@Valid @RequestBody Genre genre, HttpServletResponse response) {
		Genre savedGenre = genreService.createGenre(genre);
		
		publisher.publishEvent(new EventResourceCreated(this, response, savedGenre.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedGenre);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeGenre(@PathVariable Long id) {
		genreService.deleteGenreById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Genre> updateGenre(@PathVariable Long id,@Valid @RequestBody Genre genre) {
		Genre savedGenre = genreService.updateGenre(id, genre);
		
		return ResponseEntity.ok(savedGenre);
	}
}

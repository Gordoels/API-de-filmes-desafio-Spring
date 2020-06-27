package com.api.filmes.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

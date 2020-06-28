package com.api.filmes.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.api.filmes.model.Genre;
import com.api.filmes.repository.GenreRepository;

public class GenreService {
	
	@Autowired
	private GenreRepository genreRepo;

	public Genre updateGenre(Long id, Genre genre) {
		Genre savedGenre = findGenreById(id);
		BeanUtils.copyProperties(genre, savedGenre, "id");
		
		return genreRepo.save(savedGenre);
	}

	private Genre findGenreById(Long id) {
		Optional<Genre> savedGenre = genreRepo.findById(id);
		if(!savedGenre.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedGenre.get();
	}

}

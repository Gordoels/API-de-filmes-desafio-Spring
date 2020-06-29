package com.api.filmes.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.filmes.model.Genre;
import com.api.filmes.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepo;

	public Genre updateGenre(Long id, Genre genre) {
		Genre savedGenre = findGenreById(id);
		BeanUtils.copyProperties(genre, savedGenre, "id");
		
		return genreRepo.save(savedGenre);
	}

	public Genre findGenreById(Long id) {
		Optional<Genre> savedGenre = genreRepo.findById(id);
		if(!savedGenre.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedGenre.get();
	}

	public void deleteGenreById(Long id) {
		genreRepo.deleteById(id);
	}

	public Genre createGenre(@Valid Genre genre) {
		return genreRepo.save(genre);
	}

	public List<Genre> findAllGenre() {
		return genreRepo.findAll();
	}

}

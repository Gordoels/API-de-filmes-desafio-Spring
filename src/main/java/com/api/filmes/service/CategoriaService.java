package com.api.filmes.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.filmes.model.Categoria;
import com.api.filmes.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	public Categoria updateCategoria(Long id, Categoria categoria) {
		Categoria savedCategory = findCategoryById(id);
		BeanUtils.copyProperties(categoria, savedCategory, "id");
		
		return catRepo.save(savedCategory);
	}

	private Categoria findCategoryById(Long id) {
		Optional<Categoria> savedCategory = catRepo.findById(id);
		
		if(!savedCategory.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return savedCategory.get();
	}
}

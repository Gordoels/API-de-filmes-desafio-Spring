package com.api.filmes.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.filmes.model.Categoria;
import com.api.filmes.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	@GetMapping
	public List<Categoria> listAll() {
		return catRepo.findAll();
	}
}

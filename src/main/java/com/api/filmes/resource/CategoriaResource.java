package com.api.filmes.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.filmes.model.Categoria;
import com.api.filmes.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	@GetMapping
	public List<Categoria> listAllCategories() {
		return catRepo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> createCategory(@RequestBody Categoria cat, HttpServletResponse response) {
		Categoria savedCategory = catRepo.save(cat);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedCategory.getId()).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(savedCategory);
	}
	
	@GetMapping("/{id}")
	public Optional<Categoria> FindById(@PathVariable Long id) {
		return catRepo.findById(id);
	}
}

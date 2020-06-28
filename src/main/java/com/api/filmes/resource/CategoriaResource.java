package com.api.filmes.resource;

import java.util.List;
import java.util.Optional;

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
import com.api.filmes.model.Categoria;
import com.api.filmes.repository.CategoriaRepository;
import com.api.filmes.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private CategoriaService catService;
	
	@GetMapping
	public List<Categoria> listAllCategories() {
		return catRepo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> createCategory(@Valid @RequestBody Categoria cat, HttpServletResponse response) {
		Categoria savedCategory = catRepo.save(cat);
		
		publisher.publishEvent(new EventResourceCreated(this, response, savedCategory.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
	}
	
	@GetMapping("/{id}")
	public Categoria findCategoryById(@PathVariable Long id) {
		Optional<Categoria> cat = catRepo.findById(id);
		if(!cat.isPresent()) {
			throw new IllegalArgumentException();
		}
		return cat.get();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeCategory(@PathVariable Long id) {
		catRepo.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> updateCategory(@PathVariable Long id,@Valid @RequestBody Categoria categoria) {
		Categoria savedCategory = catService.updateCategoria(id, categoria);
		
		return ResponseEntity.ok(savedCategory);
	}
}

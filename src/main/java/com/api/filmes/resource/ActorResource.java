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
import com.api.filmes.model.Actor;
import com.api.filmes.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorResource {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ActorService actorService;
	
	@GetMapping
	public List<Actor> listAllActors() {
		return actorService.findAllActors();
	}
	
	@PostMapping
	public ResponseEntity<Actor> createActor(@Valid @RequestBody Actor actor, HttpServletResponse response) {
		Actor savedCategory = actorService.createActors(actor);
		
		publisher.publishEvent(new EventResourceCreated(this, response, savedCategory.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
	}
	
	@GetMapping("/{id}")
	public Actor findActorById(@PathVariable Long id) {
		Actor actor = actorService.findGenreById(id);
		
		return actor;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeActor(@PathVariable Long id) {
		actorService.deleteActorById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable Long id,@Valid @RequestBody Actor actor) {
		Actor savedActor = actorService.updateActor(id, actor);
		
		return ResponseEntity.ok(savedActor);
	}
}

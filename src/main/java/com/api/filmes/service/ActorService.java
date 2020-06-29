package com.api.filmes.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.filmes.model.Actor;
import com.api.filmes.repository.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepo;
	
	public Actor updateActor(Long id, Actor actor) {
		Actor savedActor = findGenreById(id);
		BeanUtils.copyProperties(actor, savedActor, "id");
		
		return actorRepo.save(savedActor);
	}

	public Actor findGenreById(Long id) {
		Optional<Actor> savedActor = actorRepo.findById(id);
		
		if(!savedActor.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedActor.get();
	}

	public void deleteActorById(Long id) {
		actorRepo.deleteById(id);
	}

	public Actor createActors(@Valid Actor actor) {
		return actorRepo.save(actor);
	}

	public List<Actor> findAllActors() {
		return actorRepo.findAll();
	}
}

package com.api.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.filmes.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}

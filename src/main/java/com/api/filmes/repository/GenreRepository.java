package com.api.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.filmes.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}

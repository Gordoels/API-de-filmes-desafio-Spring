package com.api.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.filmes.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

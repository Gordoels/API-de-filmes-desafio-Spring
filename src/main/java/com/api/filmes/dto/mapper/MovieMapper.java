package com.api.filmes.dto.mapper;

import org.springframework.stereotype.Component;

import com.api.filmes.dto.MovieDTO;
import com.api.filmes.model.Movie;

@Component
class MovieMapper {

    MovieDTO map(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        return dto;
    }

    Movie map(MovieDTO dto) {
        Movie movie;
        if (dto.getId() != null) {
            movie = new Movie(dto.getId());
        } else {
            movie = new Movie();
        }
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        return movie;
    }
}

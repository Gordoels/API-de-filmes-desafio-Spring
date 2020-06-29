package com.api.filmes.dto;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.api.filmes.model.MovieDescription;

import lombok.Data;

@Data
public class MovieDTO {
	
	private Long id;
	
	@NotNull
	@Size(min=1, max=50)
	private String title;
	
	@Embedded
	private MovieDescription description;
}

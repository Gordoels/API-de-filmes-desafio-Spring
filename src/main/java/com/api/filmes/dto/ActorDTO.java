package com.api.filmes.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ActorDTO {
	
	
	private Long id;
	
	@NotNull
	@Size(min=1, max=40)
	private String name;
}

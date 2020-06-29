package com.api.filmes.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class MovieDescription {

	
	private String director;
	
	@ManyToOne
	@JoinColumn(name = "id_actor")
	private Actor actor;
	
	private String originalLanguage;
	private String originalTitle;
	private String release_year;
	private String overview;
	private String adult;
	
}

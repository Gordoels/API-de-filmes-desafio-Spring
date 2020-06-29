package com.api.filmes.repository.filter;

import com.api.filmes.model.Genre;

public class MovieFilter {
	
	private String title;
	private Genre genre;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}

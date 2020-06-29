package com.api.filmes.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.api.filmes.model.Genre;
import com.api.filmes.resource.GenreResource;
import com.api.filmes.service.ActorService;
import com.api.filmes.service.GenreService;
import com.api.filmes.service.MovieService;

import io.restassured.http.ContentType;

@WebMvcTest
public class GenreControllerTest {

	@Autowired
	private GenreResource genreResource;
	
	@MockBean
	private MovieService movieService;
	
	@MockBean
	private ActorService actorService;
	
	@MockBean
	private GenreService genreService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.genreResource);
	}
	
	@Test
	public void mustReturnSuccess_WhenSearchGenre() {
		
		when(this.genreService.findGenreById(1L)).thenReturn(new Genre());
		
		given().accept(ContentType.JSON)
		.when().get("/genres/{id}", 1L)
		.then().statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void mustReturnNotFound_WhenSearchGenre() {
		when(this.genreService.findGenreById(5L)).thenReturn(null);
		
		given().accept(ContentType.JSON)
		.when().get("/genres/{id}", 5L)
		.then().statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void mustReturnBadRequest_WhenSearchGenre() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/genres/{id}", "asd")
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.genreService, never()).findGenreById(-1L);
	}
}

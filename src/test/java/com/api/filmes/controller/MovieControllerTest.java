package com.api.filmes.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.api.filmes.model.Movie;
import com.api.filmes.resource.MovieResource;
import com.api.filmes.service.ActorService;
import com.api.filmes.service.GenreService;
import com.api.filmes.service.MovieService;

import io.restassured.http.ContentType;

@WebMvcTest
public class MovieControllerTest {

	@Autowired
	private MovieResource movieResource;
	
	@MockBean
	private MovieService movieService;
	
	@MockBean
	private ActorService actorService;
	
	@MockBean
	private GenreService genreService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.movieResource);
	}
	
	@Test
	public void mustReturnSuccess_WhenSearchMovie() {
		
		when(this.movieService.findMovieById(1L)).thenReturn(new Movie());
		
		given().accept(ContentType.JSON)
		.when().get("/movies/{id}", 1L)
		.then().statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void mustReturnNotFound_WhenSearchMovie() {
		when(this.movieService.findMovieById(5L)).thenReturn(null);
		
		given().accept(ContentType.JSON)
		.when().get("/movies/{id}", 5L)
		.then().statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void mustReturnBadRequest_WhenSearchMovie() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/movies/{id}", "asd")
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.movieService, never()).findMovieById(-1L);
	}
}

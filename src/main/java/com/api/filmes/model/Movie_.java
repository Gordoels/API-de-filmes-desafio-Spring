package com.api.filmes.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Movie.class)
public abstract class Movie_ {

	public static volatile SingularAttribute<Movie, Genre> genre;
	public static volatile SingularAttribute<Movie, MovieDescription> description;
	public static volatile SingularAttribute<Movie, Long> id;
	public static volatile SingularAttribute<Movie, String> title;

	public static final String GENRE = "genre";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String TITLE = "title";

}


package com.api.filmes.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MovieDescription.class)
public abstract class MovieDescription_ {

	public static volatile SingularAttribute<MovieDescription, Actor> actor;
	public static volatile SingularAttribute<MovieDescription, String> overview;
	public static volatile SingularAttribute<MovieDescription, String> director;
	public static volatile SingularAttribute<MovieDescription, String> originalTitle;
	public static volatile SingularAttribute<MovieDescription, String> release_year;
	public static volatile SingularAttribute<MovieDescription, String> originalLanguage;
	public static volatile SingularAttribute<MovieDescription, String> adult;

	public static final String ACTOR = "actor";
	public static final String OVERVIEW = "overview";
	public static final String DIRECTOR = "director";
	public static final String ORIGINAL_TITLE = "originalTitle";
	public static final String RELEASE_YEAR = "release_year";
	public static final String ORIGINAL_LANGUAGE = "originalLanguage";
	public static final String ADULT = "adult";

}


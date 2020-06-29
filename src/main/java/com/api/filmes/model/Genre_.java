package com.api.filmes.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Genre.class)
public abstract class Genre_ {

	public static volatile SingularAttribute<Genre, String> name;
	public static volatile SingularAttribute<Genre, String> rating;
	public static volatile SingularAttribute<Genre, String> description;
	public static volatile SingularAttribute<Genre, Long> id;

	public static final String NAME = "name";
	public static final String RATING = "rating";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}


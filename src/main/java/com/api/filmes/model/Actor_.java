package com.api.filmes.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Actor.class)
public abstract class Actor_ {

	public static volatile SingularAttribute<Actor, String> nationality;
	public static volatile SingularAttribute<Actor, String> name;
	public static volatile SingularAttribute<Actor, String> birth;
	public static volatile SingularAttribute<Actor, Long> id;

	public static final String NATIONALITY = "nationality";
	public static final String NAME = "name";
	public static final String BIRTH = "birth";
	public static final String ID = "id";

}


package com.api.filmes.repository.movie;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.api.filmes.model.Movie;
import com.api.filmes.model.Movie_;
import com.api.filmes.repository.filter.MovieFilter;

public class MovieRepositoryImpl implements MovieRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Movie> movieFiltrator(MovieFilter movieFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteria = builder.createQuery(Movie.class);
		Root<Movie> root = criteria.from(Movie.class);
		
		Predicate[] predicates = createRestrictions(movieFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Movie> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	public Predicate[] createRestrictions (MovieFilter movieFilter, CriteriaBuilder builder, Root<Movie> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(movieFilter.getTitle())) {
			predicates.add(builder.like(builder.lower(root.get(Movie_.title)), "%" + movieFilter.getTitle().toLowerCase() + "%"));
		}

		if (movieFilter.getGenre() != null) {
			predicates.add(builder.like(builder.lower(root.get(Movie_.genre.toString())), "%" + movieFilter.getGenre().toString().toLowerCase() + "%"));;
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	
}

package com.gullysports.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Generic interface, which defines necessary functions for an API service.
 * 
 * @author rohan.sahu
 *
 * @param <T> Source.
 * @param <K> Type of id.
 */
public interface PaginationGenericService<T, K> {

	/**
	 * Function to get paginated list of records for the source(T).
	 * 
	 * @return Paginated List of source(T).
	 */
	public Page<T> getPaginatedItems(Pageable pageable);

	/**
	 * Function to get a source(T) object which matches the id param.
	 * 
	 * @param id Unique identifier of source(T) object.
	 * @return source(T) object.
	 */
	public T getById(K id);

	/**
	 * Function to add a source(T) object.
	 * 
	 * @param entity source(T) object.
	 * @return added source(T) object.
	 */
	public T add(T entity);

	/**
	 * Function to update a source(T) object.
	 * 
	 * @param entity source(T) object.
	 * @return updated source(T) object.
	 */
	public T update(T entity);

	/**
	 * Function to delete a source(T) object which matched the id param.
	 * 
	 * @param id Unique identifier of source(T) object.
	 */
	public void delete(K id);
}

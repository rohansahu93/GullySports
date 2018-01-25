package com.gullysports.services;

import org.springframework.data.domain.Page;

import java.util.List;

public interface PaginationGenericService<T, K> {

    public Page<T> getPaginatedItems(Page p);
    public T getById (K id);
    public T add(T entity);
    public T update(T entity);
    public void delete(K id);
}

package com.gullysports.services;

import java.util.List;

public interface GenericService<T, K> {

    public List<T> getAll();
    public T get(K id);
    public T add(T entity);
    public T update(T entity);
    public void delete(K id);

}

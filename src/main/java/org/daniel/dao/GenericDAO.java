package org.daniel.dao;

import java.util.List;
import java.util.Optional;
public interface GenericDAO<T> {
    Optional<T> findById(long id);
    void create(T entity);
    void save(T entity);
    void deleteById(long id);
    void delete(T entity);
}
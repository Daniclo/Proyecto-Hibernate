package org.daniel.dao;

import org.daniel.entity.Productor;

import java.util.List;
import java.util.Optional;

public interface ProductorDAO extends GenericDAO<Productor> {
    List<Productor> getProductores();
    void deleteProductores();
    Optional<Productor> getProductorByName(String name);
}

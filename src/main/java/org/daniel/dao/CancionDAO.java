package org.daniel.dao;

import org.daniel.entity.Cancion;

import java.util.List;
import java.util.Optional;

public interface CancionDAO extends GenericDAO<Cancion>{
    List<Cancion> getCanciones();
    void deleteCanciones();
    Optional<Cancion> findCancionByName(String name);
}

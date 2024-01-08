package org.daniel.dao;

import org.daniel.entity.Artista;
import java.util.List;
import java.util.Optional;

public interface ArtistaDAO extends GenericDAO<Artista>{
    List<Artista> getArtistas();
    void deleteArtistas();
    Optional<Artista> getArtistaByName(String name);
}

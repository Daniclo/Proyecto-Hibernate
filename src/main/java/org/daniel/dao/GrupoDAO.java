package org.daniel.dao;

import org.daniel.entity.Artista;
import org.daniel.entity.Grupo;
import org.daniel.entity.GrupoHasArtista;

import java.util.List;
import java.util.Optional;

public interface GrupoDAO extends GenericDAO<Grupo>{
    List<Grupo> getGrupos();
    void deleteGrupos();
    Optional<Grupo> getGrupoByName(String name);
    List<String> getAllGroupMembers(Grupo grupo);
    List<String> getActiveGroupMembers(Grupo grupo);
    void addArtistToGroup(Artista artista, Grupo grupo);
    void deleteArtistFromGroup(Artista artista, Grupo grupo);
    Optional<GrupoHasArtista> getArtistToGroup(Artista artista, Grupo grupo);
}

package org.daniel.dao;

import org.daniel.entity.Album;
import org.daniel.entity.Cancion;

import java.util.List;
import java.util.Optional;

public interface AlbumDAO extends GenericDAO<Album>{
    List<Album> getAlbumes();
    void deleteAlbumes();
    Optional<Album> getAlbumByName(String name);
    List<Cancion> getSongList(Album album);
}

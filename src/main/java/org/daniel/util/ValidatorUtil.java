package org.daniel.util;

import org.daniel.entity.*;
import org.daniel.service.RecordCompanyService;

import java.util.Optional;

public class ValidatorUtil {
    private static final RecordCompanyService rcs = new RecordCompanyService();
    public static boolean validateName(Album album){
        Optional<Album> albumBuscado = rcs.getAlbumByName(album.getNombre());
        return albumBuscado.isPresent();
    }
    public static boolean validateName(Cancion cancion){
        Optional<Cancion> cancionBuscada = rcs.getCancionByName(cancion.getNombre());
        return cancionBuscada.isPresent();
    }
    public static boolean validateName(Grupo grupo){
        Optional<Grupo> grupoBuscado = rcs.getGrupoByName(grupo.getNombre());
        return grupoBuscado.isPresent();
    }
    public static boolean validateName(Artista artista){
        Optional<Artista> artistaBuscado = rcs.getArtistaByName(artista.getNombre());
        return artistaBuscado.isPresent();
    }
    public static boolean validateName(Productor productor){
        Optional<Productor> productorBuscado = rcs.getProductorByName(productor.getNombre());
        return productorBuscado.isPresent();
    }
    public static boolean validateGrupoArtista(Grupo grupo, Artista artista){
        Optional<GrupoHasArtista> grupoArtistaBuscado = rcs.getArtistToGroup(artista,grupo);
        return grupoArtistaBuscado.isPresent();
    }
}
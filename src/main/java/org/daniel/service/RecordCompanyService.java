package org.daniel.service;

import org.daniel.dao.*;
import org.daniel.entity.*;
import org.daniel.util.ValidatorUtil;
import java.util.List;
import java.util.Optional;

public class RecordCompanyService {
    private final AlbumDAO albumDAO;
    private final ArtistaDAO artistaDAO;
    private final CancionDAO cancionDAO;
    private final ProductorDAO productorDAO;
    private final GrupoDAO grupoDAO;
    public RecordCompanyService(){
        albumDAO = new AlbumDAOImpl(Album.class);
        artistaDAO = new ArtistaDAOImpl(Artista.class);
        productorDAO = new ProductorDAOImpl(Productor.class);
        cancionDAO = new CancionDAOImpl(Cancion.class);
        grupoDAO = new GrupoDAOImpl(Grupo.class);
    }


    public Optional<Artista> getArtistaById(Long id){ return artistaDAO.findById(id); }
    public void createArtist(Artista artist){
        if (ValidatorUtil.validateName(artist))System.err.println("Operación cancelada: ya existe un elemento con este nombre");
        else artistaDAO.create(artist);
    }
    public void saveArtista(Artista artist){ artistaDAO.save(artist); }
    public void deleteArtistaById(Long id){ artistaDAO.deleteById(id); }
    public void deleteArtista(Artista artist){ artistaDAO.delete(artist); }
    public List<Artista> getAllArtistas(){ return artistaDAO.getArtistas(); }
    public void deleteAllArtistas(){ artistaDAO.deleteArtistas(); }
    public Optional<Artista> getArtistaByName(String name){ return artistaDAO.getArtistaByName(name); }


    public Optional<Grupo> getGrupoById(Long id){ return grupoDAO.findById(id); }
    public void createGrupo(Grupo grupo){
        if (ValidatorUtil.validateName(grupo))System.err.println("Operación cancelada: ya existe un elemento con este nombre");
        else grupoDAO.create(grupo);
    }
    public void saveGrupo(Grupo grupo){ grupoDAO.save(grupo); }
    public void deleteGrupoById(Long id){ grupoDAO.deleteById(id); }
    public void deleteGrupo(Grupo grupo){ grupoDAO.delete(grupo); }
    public List<Grupo> getAllGrupos(){ return grupoDAO.getGrupos(); }
    public void deleteAllGrupos(){ grupoDAO.deleteGrupos(); }
    public Optional<Grupo> getGrupoByName(String name){ return grupoDAO.getGrupoByName(name); }
    public List<String> getAllGroupMembers(Grupo grupo){ return grupoDAO.getAllGroupMembers(grupo); }
    public List<String> getActiveGroupMembers(Grupo grupo){ return grupoDAO.getActiveGroupMembers(grupo); }
    public void addArtistToGroup(Artista artista, Grupo grupo){ grupoDAO.addArtistToGroup(artista, grupo); }
    public void deleteArtistFromGroup(Artista artista, Grupo grupo){ grupoDAO.deleteArtistFromGroup(artista, grupo); }
    public Optional<GrupoHasArtista> getArtistToGroup(Artista artista, Grupo grupo){
        if (ValidatorUtil.validateName(artista) && ValidatorUtil.validateName(grupo)) return grupoDAO.getArtistToGroup(artista,grupo);
        else System.err.println("Error, el artista o grupo buscados no existen.");
        return Optional.of(new GrupoHasArtista());
    }


    public Optional<Album> getAlbumById(Long id){ return albumDAO.findById(id); }
    public void createAlbum(Album album){
        if (ValidatorUtil.validateName(album))System.err.println("Operación cancelada: ya existe un elemento con este nombre");
        else albumDAO.create(album);
    }
    public void saveAlbum(Album album){ albumDAO.save(album); }
    public void deleteAlbumById(Long id){ albumDAO.deleteById(id); }
    public void deleteAlbum(Album album){ albumDAO.delete(album); }
    public List<Album> getAllAlbumes(){ return albumDAO.getAlbumes(); }
    public void deleteAllAlbumes(){ albumDAO.deleteAlbumes(); }
    public Optional<Album> getAlbumByName(String name){ return albumDAO.getAlbumByName(name); }
    public List<Cancion> getSongListFromAlbum(Album album){ return albumDAO.getSongList(album); }


    public Optional<Cancion> getCancionById(Long id){ return cancionDAO.findById(id); }
    public void createCancion(Cancion cancion){
        if (ValidatorUtil.validateName(cancion))System.err.println("Operación cancelada: ya existe un elemento con este nombre");
        else cancionDAO.create(cancion);
    }
    public void saveCancion(Cancion cancion){ cancionDAO.save(cancion); }
    public void deleteCancionById(Long id){ cancionDAO.deleteById(id); }
    public void deleteCancion(Cancion cancion){ cancionDAO.delete(cancion); }
    public List<Cancion> getAllCanciones(){ return cancionDAO.getCanciones(); }
    public void deleteAllCanciones(){ cancionDAO.deleteCanciones(); }
    public Optional<Cancion> getCancionByName(String name){ return cancionDAO.findCancionByName(name); }


    public Optional<Productor> getProductorById(Long id){ return productorDAO.findById(id); }
    public void createProductor(Productor productor){
        if (ValidatorUtil.validateName(productor))System.err.println("Operación cancelada: ya existe un elemento con este nombre");
        else productorDAO.create(productor);
    }
    public void saveProductor(Productor productor){ productorDAO.save(productor); }
    public void deleteProductorById(Long id){ productorDAO.deleteById(id); }
    public void deleteProductor(Productor productor){ productorDAO.delete(productor); }
    public List<Productor> getAllProductores(){ return productorDAO.getProductores(); }
    public void deleteAllProductores(){ productorDAO.deleteProductores(); }
    public Optional<Productor> getProductorByName(String name){ return productorDAO.getProductorByName(name); }
}
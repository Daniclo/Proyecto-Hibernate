package org.daniel.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.daniel.entity.Album;
import org.daniel.entity.Cancion;
import org.daniel.entity.Cancion_;
import org.daniel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class AlbumDAOImpl extends GenericDAOImpl<Album> implements AlbumDAO{
    public AlbumDAOImpl(Class<Album> entityClass) {
        super(entityClass);
    }
    public List<Album> getAlbumes(){
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Album> query = session.createQuery("from Album", Album.class);
            return query.getResultList();
        }
    }

    @Override
    public void deleteAlbumes() {
        for(Album album:getAlbumes()) delete(album);
    }

    public Optional<Album> getAlbumByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Album> query = session.createQuery("from Album where nombre = :nombreAlbum",
                    Album.class)
                    .setParameter("nombreAlbum", name);
            return query.uniqueResultOptional();
        }
    }
    // Para este método, en el menú se dará la opción de obtener el objeto Album
    // que se le pasa por ID o por nombre.
    public List<Cancion> getSongList(Album album){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Cancion> criteriaQuery = criteriaBuilder.createQuery(Cancion.class);
            Root<Cancion> root = criteriaQuery.from(Cancion.class);
            criteriaQuery.where(criteriaBuilder.equal(root.get(Cancion_.ALBUM),album));
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
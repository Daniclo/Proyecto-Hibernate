package org.daniel.dao;

import org.daniel.entity.Artista;
import org.daniel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class ArtistaDAOImpl extends GenericDAOImpl<Artista> implements ArtistaDAO {
    public ArtistaDAOImpl(Class<Artista> entityClass) {
        super(entityClass);
    }
    public List<Artista> getArtistas(){
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Artista> query = session.createQuery("from Artista ", Artista.class);
            return query.getResultList();
        }
    }

    @Override
    public void deleteArtistas() {
        for (Artista artista:getArtistas()) delete(artista);
    }

    @Override
    public Optional<Artista> getArtistaByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Artista> query = session.createQuery("from Artista where nombre = :nombreArtista",
                    Artista.class)
                    .setParameter("nombreArtista", name);
            return query.uniqueResultOptional();
        }
    }
}

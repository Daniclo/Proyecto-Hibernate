package org.daniel.dao;

import org.daniel.entity.Cancion;
import org.daniel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class CancionDAOImpl extends GenericDAOImpl<Cancion> implements CancionDAO {
    public CancionDAOImpl(Class<Cancion> entityClass) {
        super(entityClass);
    }
    public List<Cancion> getCanciones(){
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Cancion> query = session.createQuery("from Cancion ", Cancion.class);
            return query.getResultList();
        }
    }

    @Override
    public void deleteCanciones() {
        for (Cancion cancion:getCanciones()) delete(cancion);
    }

    public Optional<Cancion> findCancionByName(String name){
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Cancion> query = session.createQuery("from Cancion where nombre = :nombreCancion",
                            Cancion.class)
                    .setParameter("nombreCancion",name);
            return query.uniqueResultOptional();
        }
    }
}
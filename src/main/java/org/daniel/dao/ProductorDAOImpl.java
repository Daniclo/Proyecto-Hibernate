package org.daniel.dao;

import org.daniel.entity.Productor;
import org.daniel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class ProductorDAOImpl extends GenericDAOImpl<Productor> implements ProductorDAO{
    public ProductorDAOImpl(Class<Productor> entityClass) {
        super(entityClass);
    }
    public List<Productor> getProductores(){
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Productor> query = session.createQuery("from Productor ", Productor.class);
            return query.getResultList();
        }
    }

    @Override
    public void deleteProductores() {
        for (Productor productor:getProductores()) delete(productor);
    }

    @Override
    public Optional<Productor> getProductorByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Productor> query = session.createQuery("from Productor where  nombre = :nombreProductor",
                    Productor.class)
                    .setParameter("nombreProductor", name);
            return query.uniqueResultOptional();
        }
    }
}
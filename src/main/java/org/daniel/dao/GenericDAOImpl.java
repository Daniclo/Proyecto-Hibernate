package org.daniel.dao;

import org.daniel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    private final Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    @Override
    public Optional<T> findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            return Optional.ofNullable(session.find(entityClass, id));
        }
    }

    @Override
    public void create(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.persist(entity);
                tx.commit();
            } catch (RuntimeException e) {
                if(tx != null) tx.rollback();
            }
        }
    }

    @Override
    public void save(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            if (session.find(entityClass, id) != null) session.remove(session.find(entityClass, id));
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }
}
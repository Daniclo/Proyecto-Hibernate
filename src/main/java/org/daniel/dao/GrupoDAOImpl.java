package org.daniel.dao;

import jakarta.persistence.criteria.*;
import org.daniel.dto.GrupoHasArtistasDTO;
import org.daniel.entity.*;
import org.daniel.util.HibernateUtil;
import org.daniel.util.ValidatorUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GrupoDAOImpl extends GenericDAOImpl<Grupo> implements GrupoDAO {
    public GrupoDAOImpl(Class<Grupo> entityClass) {
        super(entityClass);
    }
    public List<Grupo> getGrupos(){
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Grupo> query = session.createQuery("from Grupo ", Grupo.class);
            return query.getResultList();
        }
    }
    @Override
    public void deleteGrupos() {
        for (Grupo grupo:getGrupos()) delete(grupo);
    }
    @Override
    public Optional<Grupo> getGrupoByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Query<Grupo> query = session.createQuery("from Grupo where nombre = :nombreGrupo",
                    Grupo.class)
                    .setParameter("nombreGrupo", name);
            return query.uniqueResultOptional();
        }
    }
    @Override
    public List<String> getAllGroupMembers(Grupo grupo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<GrupoHasArtistasDTO> criteriaQuery = criteriaBuilder.createQuery(GrupoHasArtistasDTO.class);

            Root<GrupoHasArtista> root = criteriaQuery.from(GrupoHasArtista.class);
            Join<GrupoHasArtista, Grupo> join1 = root.join(GrupoHasArtista_.grupo);
            Join<GrupoHasArtista, Artista> join2 = root.join(GrupoHasArtista_.artista);

            Path<Grupo> grupoPath = join1.get(Grupo_.NOMBRE);
            Path<Artista> artistaPath = join2.get(Artista_.NOMBRE);
            Path<Boolean> siguePath = root.get(GrupoHasArtista_.SIGUE_EN_EL_GRUPO);

            criteriaQuery.multiselect(grupoPath,artistaPath,siguePath);
            criteriaQuery.where(criteriaBuilder.equal(join1.get(Grupo_.NOMBRE),grupo.getNombre()));

            List<GrupoHasArtistasDTO> select = session.createQuery(criteriaQuery).getResultList();
            List<String> artistas = new ArrayList<>();
            for (GrupoHasArtistasDTO dto:select){
                artistas.add(dto.getNombreArtista());
            }
            return artistas;
        }
    }
    @Override
    public List<String> getActiveGroupMembers(Grupo grupo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<GrupoHasArtistasDTO> criteriaQuery = criteriaBuilder.createQuery(GrupoHasArtistasDTO.class);

            Root<GrupoHasArtista> root = criteriaQuery.from(GrupoHasArtista.class);
            Join<GrupoHasArtista, Grupo> join1 = root.join(GrupoHasArtista_.grupo);
            Join<GrupoHasArtista, Artista> join2 = root.join(GrupoHasArtista_.artista);

            Path<Grupo> grupoPath = join1.get(Grupo_.NOMBRE);
            Path<Artista> artistaPath = join2.get(Artista_.NOMBRE);
            Path<Boolean> siguePath = root.get(GrupoHasArtista_.SIGUE_EN_EL_GRUPO);

            criteriaQuery.multiselect(grupoPath,artistaPath,siguePath);
            criteriaQuery.where(criteriaBuilder.equal(join1.get(Grupo_.NOMBRE),grupo.getNombre()));

            List<GrupoHasArtistasDTO> select = session.createQuery(criteriaQuery).getResultList();
            List<String> artistas = new ArrayList<>();
            for (GrupoHasArtistasDTO dto:select){
                if (dto.isEnElGrupo()) artistas.add(dto.getNombreArtista());
            }
            return artistas;
        }
    }
    @Override
    public void addArtistToGroup(Artista artista, Grupo grupo) {
        if (ValidatorUtil.validateName(artista) && ValidatorUtil.validateName(grupo)){
            GrupoHasArtista entity = new GrupoHasArtista(grupo,artista,true);
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
    }
    @Override
    public void deleteArtistFromGroup(Artista artista, Grupo grupo) {
        Optional<GrupoHasArtista> op = getArtistToGroup(artista, grupo);
        if (op.isPresent()){
            GrupoHasArtista grupoHasArtista = op.get();
            grupoHasArtista.setSigueEnElGrupo(false);
            try (Session session = HibernateUtil.getSessionFactory().openSession();) {
                session.beginTransaction();
                session.merge(grupoHasArtista);
                session.getTransaction().commit();
            }
        }
    }
    @Override
    public Optional<GrupoHasArtista> getArtistToGroup(Artista artista, Grupo grupo) {
        GrupoHasArtista entity1 = new GrupoHasArtista(grupo,artista,true);
        GrupoHasArtista entity2 = new GrupoHasArtista(grupo,artista,false);
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Optional<GrupoHasArtista> result1 = Optional.ofNullable(session.get(GrupoHasArtista.class, entity1));
            Optional<GrupoHasArtista> result2 = Optional.ofNullable(session.get(GrupoHasArtista.class, entity2));
            if (result1.isPresent()) return result1;
            else if (result2.isPresent()) return result2;
            else return Optional.of(new GrupoHasArtista());
        }
    }
}
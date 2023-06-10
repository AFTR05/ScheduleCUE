package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class TypeAdminImpl implements ObjectDao<TypeAdmin> {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<TypeAdmin> list() {
        return null;
    }

    @Override
    public TypeAdmin byId(String id) {
        return null;
    }

    @Override
    public TypeAdmin save(TypeAdmin typeAdmin) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public TypeAdmin update(String id, TypeAdmin typeAdmin) {
        return null;
    }

    @Override
    public TypeAdmin byName(String name) {
        Query query=entityManager.createQuery("select t from TypeAdmin t where t.typeAdmin=?1", TypeAdmin.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (TypeAdmin) query.getSingleResult();
    }
}

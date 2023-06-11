package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.DurationType;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeSubject;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;
@Repository
@Transactional
public class TypeSubjectImpl implements ObjectDao<TypeSubject> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<TypeSubject> list() {
        return null;
    }

    @Override
    public TypeSubject byId(String id) {
        return null;
    }

    @Override
    public TypeSubject save(TypeSubject typeSubject) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public TypeSubject update(String id, TypeSubject typeSubject) {
        return null;
    }

    @Override
    public TypeSubject byName(String name) {
        Query query=entityManager.createQuery("select t from TypeSubject t where t.typeSubject=?1", TypeSubject.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (TypeSubject) query.getSingleResult();
    }
}

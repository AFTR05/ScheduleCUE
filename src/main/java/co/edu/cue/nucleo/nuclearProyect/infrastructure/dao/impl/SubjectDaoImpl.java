package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.User;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class SubjectDaoImpl implements ObjectDao<Subject> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Subject> list() {
        String query = "FROM Subject";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Subject byId(String id) {
        return entityManager.find(Subject.class, id);
    }

    @Override
    public Subject save(Subject o) {
        return entityManager.merge(o);
    }

    @Override
    public void delete(String id) {
        Subject subject= entityManager.find(Subject.class, id);
        entityManager.remove(subject);
    }

    @Override
    public Subject update(String id, Subject o) {
        Subject room=entityManager.find(Subject.class, id);
        room.setName(o.getName());
        room.setTypeSubject(o.getTypeSubject());
        room.setDurationType(o.getDurationType());
        room.setId(o.getId());
        room.setCountSemanalHours(o.getCountSemanalHours());
        entityManager.merge(o);
        return o;
    }

    @Override
    public Subject byName(String name) {
        Query query=entityManager.createQuery("select s from Subject s where s.name=?1", Subject.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (Subject) query.getSingleResult();
    }
}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Curse;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class CurseDaoImpl implements ObjectDao<Curse> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Curse> list() {
        String query = "FROM Room";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Curse byId(String id) {
        return entityManager.find(Curse.class, id);
    }

    @Override
    public Curse save(Curse curse) {
        return entityManager.merge(curse);
    }

    @Override
    public void delete(String id) {
        Curse curse= entityManager.find(Curse.class, id);
        entityManager.remove(curse);
    }

    @Override
    public Curse update(String id, Curse curse) {
        Curse curse1= entityManager.find(Curse.class, id);
        curse1.setId(curse.getId());
        curse1.setSubject(curse.getSubject());
        curse1.setProgram(curse.getProgram());
        curse1.setTeacher(curse.getTeacher());
        entityManager.merge(curse1);
        return curse1;
    }

    @Override
    public Curse byName(String program) {
        Query query=entityManager.createQuery("select c from Curse c where c.program=?1", Curse.class);
        query.setParameter(1, program);
        query.setMaxResults(1);
        return (Curse) query.getSingleResult();
    }
}

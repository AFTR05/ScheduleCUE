package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.DurationType;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Modality;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class DurationTypeImpl implements ObjectDao<DurationType> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<DurationType> list() {
        return null;
    }

    @Override
    public DurationType byId(String id) {
        return null;
    }

    @Override
    public DurationType save(DurationType durationType) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public DurationType update(String id, DurationType durationType) {
        return null;
    }

    @Override
    public DurationType byName(String name) {
        Query query=entityManager.createQuery("select d from DurationType d where d.type=?1", DurationType.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (DurationType) query.getSingleResult();
    }
}

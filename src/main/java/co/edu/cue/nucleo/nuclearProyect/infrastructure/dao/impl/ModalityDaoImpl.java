package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.Modality;
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
public class ModalityDaoImpl implements ObjectDao<Modality> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Modality> list() {
        return null;
    }

    @Override
    public Modality byId(String id) {
        return null;
    }

    @Override
    public Modality save(Modality modality) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Modality update(String id, Modality modality) {
        return null;
    }

    @Override
    public Modality byName(String name) {
        Query query=entityManager.createQuery("select m from Modality m where m.modality=?1", Modality.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (Modality) query.getSingleResult();
    }
}

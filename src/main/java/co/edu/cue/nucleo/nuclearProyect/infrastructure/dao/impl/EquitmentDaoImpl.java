package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class EquitmentDaoImpl implements ObjectDao<EquitmentRoom> {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<EquitmentRoom> list() {
        return null;
    }

    @Override
    public EquitmentRoom byId(String id) {
        return entityManager.find(EquitmentRoom.class, id);
    }

    @Override
    public EquitmentRoom save(EquitmentRoom equitmentRoom) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public EquitmentRoom update(String id, EquitmentRoom equitmentRoom) {
        return null;
    }

    @Override
    public EquitmentRoom byName(String name) {
        return null;
    }
}

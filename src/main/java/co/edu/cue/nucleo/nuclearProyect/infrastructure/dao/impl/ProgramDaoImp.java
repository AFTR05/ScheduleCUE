package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProgramDaoImp implements ObjectDao<Program> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Program> list() {
        return null;
    }

    @Override
    public Program byId(String id) {
        return null;
    }

    @Override
    public Program save(Program program) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Program update(String id, Program program) {
        return null;
    }

    @Override
    public Program byName(String name) {
        Query query=entityManager.createQuery("select p from Program p where p.name=?1", Program.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (Program) query.getSingleResult();
    }
}

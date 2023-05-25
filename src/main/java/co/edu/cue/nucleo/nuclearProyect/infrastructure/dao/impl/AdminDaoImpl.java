package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class AdminDaoImpl implements ObjectDao<Administrator> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Administrator> list() {
        String query = "FROM Administrator ";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Administrator byId(String id) {
        return entityManager.find(Administrator.class, id);
    }

    @Override
    public Administrator save(Administrator a) {
        return entityManager.merge(a);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Administrator update(String id, Administrator a) {
        Administrator admin=entityManager.find(Administrator.class, id);
        admin.setName(a.getName());
        admin.setPassword(a.getPassword());
        admin.setEmail(a.getEmail());
        admin.setTypeAdmin(a.getTypeAdmin());
        admin.setId(a.getId());
        entityManager.merge(a);
        return a;
    }

    @Override
    public Administrator byName(String name) {
        return null;
    }
}

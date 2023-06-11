package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
    public Administrator update(String password, Administrator a) {
        Administrator admin=entityManager.find(Administrator.class, a.getId());
        admin.setName(a.getName());
        admin.setPassword(password);
        admin.setEmail(a.getEmail());
        admin.setTypeAdmin(a.getTypeAdmin());
        admin.setId(a.getId());
        entityManager.merge(admin);
        return admin;
    }

    @Override
    public Administrator byName(String name) {
        Query query=entityManager.createQuery("select a from Administrator a where a.name=?1",Administrator.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (Administrator) query.getSingleResult();
    }

    public Optional<Administrator> byCredenciales(String id, String password) {
        try{
            Query query=entityManager.createQuery("select s from Administrator s where s.id=?1", Administrator.class);
            query.setParameter(1, id);
            query.setMaxResults(1);
            query.setMaxResults(1);
            Administrator s=(Administrator) query.getSingleResult();
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            if (argon2.verify(s.getPassword(), password)) {
                return Optional.of(s);
            }
        }catch(NoResultException ex){
            return Optional.empty();
        }
        return Optional.empty();
    }
}

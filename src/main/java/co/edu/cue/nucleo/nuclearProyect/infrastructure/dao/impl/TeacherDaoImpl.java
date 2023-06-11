package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
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

public class TeacherDaoImpl implements ObjectDao<Teacher> {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Teacher> list() {
        String query = "FROM Teacher ";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Teacher byId(String id) {return entityManager.find(Teacher.class, id);
    }

    @Override
    public Teacher save(Teacher t) {return entityManager.merge(t);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Teacher update(String password, Teacher t) {
        Teacher teacher=entityManager.find(Teacher.class, t.getId());
        teacher.setName(t.getName());
        teacher.setPassword(password);
        teacher.setEmail(t.getEmail());
        teacher.setCourse(t.getCourse());
        teacher.setId(t.getId());
        teacher.setActive(t.getActive());
        save(teacher);
        return teacher;
    }

    @Override
    public Teacher byName(String name) {
        Query query=entityManager.createQuery("select t from Teacher t where t.name=?1",Teacher.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (Teacher) query.getSingleResult();
    }

    public Optional<Teacher> byCredenciales(String id, String password) {
        try{
            Query query=entityManager.createQuery("select s from Teacher s where s.id=?1", Teacher.class);
            query.setParameter(1, id);
            query.setMaxResults(1);
            query.setMaxResults(1);
            Teacher s=(Teacher) query.getSingleResult();
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

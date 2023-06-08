package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        save(t);
        return teacher;
    }

    @Override
    public Teacher byName(String name) {
        Query query=entityManager.createQuery("select t from Teacher t where t.name=?1",Teacher.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (Teacher) query.getSingleResult();
    }
}

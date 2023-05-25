package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    public Teacher update(String id, Teacher t) {
        Teacher teacher=entityManager.find(Teacher.class, id);
        teacher.setName(t.getName());
        teacher.setPassword(t.getPassword());
        teacher.setEmail(t.getEmail());
        teacher.setCourse(t.getCourse());
        teacher.setId(t.getId());
        entityManager.merge(t);
        return t;
    }

    @Override
    public Teacher byName(String name) {
        return null;
    }
}

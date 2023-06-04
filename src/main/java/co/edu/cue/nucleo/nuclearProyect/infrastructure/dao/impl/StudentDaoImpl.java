package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;


import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class StudentDaoImpl implements ObjectDao<Student> {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Student> list() {
        String query = "FROM Student";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Student byId(String id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student s) {
        return entityManager.merge(s);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Student update(String password, Student s) {
        Student student=entityManager.find(Student.class, s.getId());
        student.setName(s.getName());
        student.setPassword(password);
        student.setEmail(s.getEmail());
        student.setOwnSemester(s.getOwnSemester());
        student.setId(s.getId());
        save(s);
        return student;
    }

    @Override
    public Student byName(String name) {
        return null;
    }
}

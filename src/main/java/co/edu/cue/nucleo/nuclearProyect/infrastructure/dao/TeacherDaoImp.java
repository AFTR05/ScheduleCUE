package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional

public class TeacherDaoImp implements TeacherDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Teacher> getTeachers() {
        String query = "FROM Teacher";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void register(Teacher teacher) {
        entityManager.merge(teacher);
    }
}

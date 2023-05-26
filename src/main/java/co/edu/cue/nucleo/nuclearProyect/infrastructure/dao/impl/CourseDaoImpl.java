package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import jakarta.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class CourseDaoImpl implements ObjectDao<Course> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Course> list() {
        String query = "FROM Course";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Course byId(String id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course byName(String name) {
        Query query=entityManager.createQuery("select c from Course c where c.subject.name=?1", Course.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (Course) query.getSingleResult();
    }

    @Override
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public void delete(String id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);

    }

    @Override
    public Course update(String id, Course source) {
        Course course =entityManager.find(Course.class, id);
        course.setTeacher(source.getTeacher());
        course.setSubject(source.getSubject());
        course.setDuration(source.getDuration());
        course.setId(source.getId());
        course.setStudent(source.getStudent());
        course.setProgram(source.getProgram());
        course.setHourRoom(source.getHourRoom());
        course.setEquitmentRoom(source.getEquitmentRoom());
        return entityManager.merge(course);
    }
}

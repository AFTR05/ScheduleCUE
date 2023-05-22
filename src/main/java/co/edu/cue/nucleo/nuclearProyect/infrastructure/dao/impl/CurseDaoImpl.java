package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.CurseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class CurseDaoImpl implements CurseDao<Course> {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Course> listCurses() {
        String query = "FROM Course";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Course> listByTeacherId(String teacherId) {
        Query query=entityManager.createQuery("select c from Course c where c.teacher.id=?1", Course.class);
        query.setParameter(1, teacherId);
        return (List<Course>) query.getResultList();
    }

    @Override
    public List<Course> listByProgramId(String programId) {
        Query query=entityManager.createQuery("select c from Course c where c.program.id=?1", Course.class);
        query.setParameter(1, programId);
        return (List<Course>) query.getResultList();
    }

    @Override
    public List<Course> listBySubjectId(String subjectId) {
        Query query=entityManager.createQuery("select c from Course c where c.subject.id=?1", Course.class);
        query.setParameter(1, subjectId);
        return (List<Course>) query.getResultList();
    }

    @Override
    public List<Course> listByStudentId(String studentId) {
        Query query=entityManager.createQuery("SELECT p FROM Course p JOIN p.students c WHERE c.id = ?1", Course.class);
        query.setParameter(1, studentId);
        return (List<Course>) query.getResultList();
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
        course.setStudents(source.getStudents());
        course.setProgram(source.getProgram());
        course.setRoomHours(source.getRoomHours());
        return entityManager.merge(course);
    }
}

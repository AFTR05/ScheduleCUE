package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.StudentCourseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentCourseDaoImpl implements StudentCourseDao {
    @PersistenceContext
    EntityManager entityManager;
        @Override
        public void createWithNoID(String studentId, String courseId){
            Query query=entityManager.createNativeQuery("INSERT INTO `student_course` " +
                    "(`student_id`, `course_id`) VALUES (?1, ?2)");
            query.setParameter(1, studentId);
            query.setParameter(2, courseId);
            query.executeUpdate();
        }
}

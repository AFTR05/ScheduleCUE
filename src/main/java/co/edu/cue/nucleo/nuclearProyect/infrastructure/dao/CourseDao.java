package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;

import java.util.List;

public interface CourseDao<T> {
    List<Course> listCurses();

    List<Course> listByTeacherId(String teacherId);

    List<Course> listByProgramId(String subjectId);

    List<Course> listBySubjectId(String subjectId);

    List<Course> listByStudentId(String studentId);

    Course save(Course course);

    void delete(String id);

    Course update(String id, Course source);
}

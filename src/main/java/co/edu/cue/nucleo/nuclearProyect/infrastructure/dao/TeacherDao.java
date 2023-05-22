package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getTeachers();

    void register(Teacher teacher);
}

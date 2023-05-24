package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;

import java.util.List;

public interface CourseService {
    List<CourseRequestDTO> getAllCourses();

    List<CourseRequestDTO> getCoursesStudent(String studentId);

    List<CourseRequestDTO> getCoursesTeacher(String teacherId);

    List<CourseRequestDTO> getCoursesProgram(String programId);

    CourseRequestDTO createCourse(CourseRequestDTO course);
}

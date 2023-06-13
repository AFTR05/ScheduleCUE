package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.*;

import java.util.List;

public interface CourseService {
    List<CourseRequestDTO> getAllCourses();
    CourseRequestDTO createCourse(CourseInterfaceDTO course);
    CourseRequestDTO getOneCourse(String name);

    CourseRequestDTO updateRoom(String id, CourseRequestDTO course);

    List<StudentRequestDTO> getCourseStudents(String course);

    List<StudentRequestDTO> getCourseNoStudents(String course);

    CourseRequestDTO addStudent(AddStudentInterfaceDTO addStudentInterfaceDTO);
}

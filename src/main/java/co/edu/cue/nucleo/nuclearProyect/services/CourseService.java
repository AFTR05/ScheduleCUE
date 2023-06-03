package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomRequestDTO;

import java.util.List;

public interface CourseService {
    List<CourseRequestDTO> getAllCourses();
    CourseRequestDTO createCourse(CourseRequestDTO course);
    CourseRequestDTO getOneCourse(String name);

    CourseRequestDTO updateRoom(String id, CourseRequestDTO course);

}

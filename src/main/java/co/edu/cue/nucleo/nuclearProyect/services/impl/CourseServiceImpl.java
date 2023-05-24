package co.edu.cue.nucleo.nuclearProyect.services.impl;


import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.CourseDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.CourseMapper;
import co.edu.cue.nucleo.nuclearProyect.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao;
    private final CourseMapper mapper;

    @Override
    public List<CourseRequestDTO> getAllCourses() {
        return courseDao.listCurses()
                .parallelStream()
                .map(e -> mapper.mapToDTO((Course) e))
                .toList();
    }
    @Override
    public List<CourseRequestDTO> getCoursesStudent(String studentId){
        return courseDao.listByStudentId(studentId);
    }
    @Override
    public List<CourseRequestDTO> getCoursesTeacher(String teacherId){
        return courseDao.listByTeacherId(teacherId);
    }
    @Override
    public List<CourseRequestDTO> getCoursesProgram(String programId){
        return courseDao.listByProgramId(programId);
    }
    @Override
    public CourseRequestDTO createCourse(CourseRequestDTO course){
        Course nativeCourse=mapper.mapToDTO(course);
        nativeCourse.setId(course.subject().getName()+course.program().getName());
        return mapper.mapToDTO(
                courseDao.save(
                        nativeCourse
                ));
    }

    //create hour_room con el horario de disponibilidad del profesor,
    // disponibilidad de los estudiantes, hacerlo segun el orden de clasificacion de materias

}

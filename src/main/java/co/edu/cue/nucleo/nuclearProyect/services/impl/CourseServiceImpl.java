package co.edu.cue.nucleo.nuclearProyect.services.impl;


import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.CourseHourGenerator;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OrganizerListCourse;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.CourseMapper;
import co.edu.cue.nucleo.nuclearProyect.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final ObjectDao<Course> objectDao;
    private final CourseMapper mapper;

    @Override
    public List<CourseRequestDTO> getAllCourses() {
        return objectDao.list()
                .stream()
                .map(e -> mapper.mapToDTO(e))
                .toList();
    }
    @Override
    public CourseRequestDTO createCourse(CourseRequestDTO course){
        Course nativeCourse=mapper.mapToDTO(course);
        nativeCourse.setId(course.subject().getName()+course.program().getName());
        return mapper.mapToDTO(
                objectDao.save(
                        nativeCourse
                ));
    }

    @Override
    public CourseRequestDTO getOneCourse(String name){
        return mapper.mapToDTO(
                objectDao.byName(name)
        );
    }
    @Override
    public CourseRequestDTO updateRoom(String id, CourseRequestDTO course){
        Course courseUpdater=mapper.mapToDTO(course);
        courseUpdater.setId(id);
        return mapper.mapToDTO(
                objectDao.update(
                        id,courseUpdater
                ));
    }





}

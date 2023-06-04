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

    /**Este metodo traera toda la lista de courses de la base de datos
     * @return Lista de courses
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public List<CourseRequestDTO> getAllCourses() {
        return objectDao.list()
                .stream()
                .map(e -> mapper.mapToDTO(e))
                .toList();
    }

    /**
     * @param course DTO de course con datos de interfaz
     * @return El objeto que se creo en la base de datos
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public CourseRequestDTO createCourse(CourseRequestDTO course){
        Course nativeCourse=mapper.mapToEntity(course);
        nativeCourse.setId(course.subject().getName()+course.program().getName());
        return mapper.mapToDTO(
                objectDao.save(
                        nativeCourse
                ));
    }

    /**
     * @param id Es el codigo del course a buscar
     * @return El objeto que se encontro con el id digitado en la base de datos
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public CourseRequestDTO getOneCourse(String id){
        return mapper.mapToDTO(
                objectDao.byName(id)
        );
    }

    /**
     * @param id Es el codigo del course a buscar
     * @param course DTO de course con datos de interfaz
     * @return El objeto que se actualiza segun las modificaciones en la base de datos
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public CourseRequestDTO updateRoom(String id, CourseRequestDTO course){
        Course courseUpdater=mapper.mapToEntity(course);
        courseUpdater.setId(id);
        return mapper.mapToDTO(
                objectDao.update(
                        id,courseUpdater
                ));
    }





}

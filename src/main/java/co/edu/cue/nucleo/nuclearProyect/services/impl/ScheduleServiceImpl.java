package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OrganizerListCourse;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseWithSchedule;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.CourseMapper;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.ScheduleMapper;
import co.edu.cue.nucleo.nuclearProyect.services.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ObjectDao<Course> courseDao;
    private final ObjectDao<Room> roomDao;
    private final ScheduleMapper mapper;

    /**
     * Este metodo realizara la creacion de horarios en los cursos que no tengan horario
     * @return La lista de cursos
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public List<CourseWithSchedule> createSchedule(){
        List<CourseWithSchedule> sis=OrganizerListCourse.organizeWithAll(courseDao.list(),roomDao.list()).stream()
                .map(mapper::mapToDTO).collect(Collectors.toList());
        return OrganizerListCourse.organizeWithAll(courseDao.list(),roomDao.list()).stream()
                .map(mapper::mapToDTO).collect(Collectors.toList());
    }
}

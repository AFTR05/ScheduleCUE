package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.RoomHour;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.HourIntervalDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.HourRoomDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.HourRoomDaoImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OrganizerListCourse;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.SearchEntity;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseWithSchedule;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.CourseMapper;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.ScheduleMapper;
import co.edu.cue.nucleo.nuclearProyect.services.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ObjectDao<Course> courseDao;
    private final ObjectDao<Room> roomDao;
    private final HourRoomDaoImpl hourRoomDao;
    private final HourIntervalDao hourIntervalDao;
    private final ScheduleMapper mapper;

    /**
     * Este metodo realizara la creacion de horarios en los cursos que no tengan horario
     * @return La lista de cursos
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public List<CourseWithSchedule> createSchedule(){
        List<Course> createdCourses=OrganizerListCourse.organizeWithAll(courseDao.list(),roomDao.list()).stream()
                .collect(Collectors.toList());
/*        createdCourses.stream().map(c->mapper.mapToDTO(courseDao.update(c.getId(),c)));*/
        //guardar hour interval
        List<HourInterval> his=createdCourses.stream()
                .flatMap(course -> course.getHourRoom().stream()
                        .map(RoomHour::getHourInterval))
                .collect(Collectors.toList());
        his.stream().forEach(x->{
            SearchEntity.getHourInterval(x.getDay(),x.getIntervalBegin(),x.getIntervalEnd(),hourIntervalDao);
        });
        // guardar hour room
        createdCourses.stream().forEach(course -> {
            SearchEntity.createHourRooms(course,hourRoomDao,hourIntervalDao);
        });
        return createdCourses.stream().map(mapper::mapToDTO).collect(Collectors.toList());
    }
}

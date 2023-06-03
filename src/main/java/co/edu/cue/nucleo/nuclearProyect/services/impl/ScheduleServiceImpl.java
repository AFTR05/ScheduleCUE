package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OrganizerListCourse;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.CourseMapper;
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
    private final CourseMapper mapper;

    @Override
    public List<CourseRequestDTO> createSchedule(){
        return OrganizerListCourse.organizeWithAll(courseDao.list(),roomDao.list()).stream()
                .map(mapper::mapToDTO).collect(Collectors.toList());
    }
}

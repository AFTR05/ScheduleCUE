package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseWithSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ScheduleMapper {
    CourseWithSchedule mapToDTO(Course source);

    @Mapping(target = "id", ignore = true)
    Course mapToEntity(CourseWithSchedule source);
}

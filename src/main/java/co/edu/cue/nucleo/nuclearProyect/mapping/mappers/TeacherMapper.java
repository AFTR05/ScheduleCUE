package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TeacherMapper {
    @Mapping(target = "courses", source = "source.course")
    @Mapping(target = "availability", source = "hour_interval")
    TeacherRequestDTO mapToDTO(Teacher source);


    @Mapping(target = "course", source = "source.courses")
    Teacher mapToDTO(TeacherRequestDTO source);
}

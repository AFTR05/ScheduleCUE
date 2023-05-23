package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TeacherMapper {
    TeacherRequestDTO mapToDTO(Teacher source);


    @Mapping(target = "id", ignore = true)
    Teacher mapToDTO(TeacherRequestDTO source);
}

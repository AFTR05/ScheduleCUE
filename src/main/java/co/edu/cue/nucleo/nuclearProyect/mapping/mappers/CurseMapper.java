package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CurseRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CurseMapper {
    CurseRequestDTO mapToDTO(Course source);


    @Mapping(target = "id", ignore = true)
    Course mapToDTO(CurseRequestDTO source);
}

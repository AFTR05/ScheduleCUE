package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.SubjectRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SubjectMapper {
    SubjectRequestDTO mapToDTO(Subject source);


    @Mapping(target = "id", ignore = true)
    Subject mapToDTO(SubjectRequestDTO source);
}

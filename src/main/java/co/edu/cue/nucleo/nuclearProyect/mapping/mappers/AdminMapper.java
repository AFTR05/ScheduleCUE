package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AdminMapper {
    AdminRequestDTO mapToDTO(Administrator source);


    @Mapping(target = "id", ignore = true)
    Administrator mapToDTO(AdminRequestDTO source);
}

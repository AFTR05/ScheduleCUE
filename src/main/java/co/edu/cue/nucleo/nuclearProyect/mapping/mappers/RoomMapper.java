package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoomMapper {

    RoomRequestDTO mapToDTO(Room source);


    @Mapping(target = "id", ignore = true)
    Room mapToDTO(RoomRequestDTO source);

}

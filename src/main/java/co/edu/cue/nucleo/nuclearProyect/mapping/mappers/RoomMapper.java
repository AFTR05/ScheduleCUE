package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;
import org.springframework.stereotype.Component;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@Component
public interface RoomMapper {

    RoomRequestDTO mapToDTO(Room source);
  
    @Mapping(target = "id", ignore = true)
    Room mapToEntity(RoomRequestDTO source);
}

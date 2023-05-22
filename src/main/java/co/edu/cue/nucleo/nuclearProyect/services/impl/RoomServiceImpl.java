package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.RoomMapper;
import co.edu.cue.nucleo.nuclearProyect.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final ObjectDao<Room> objectDao;

    private final RoomMapper mapper;

    @Override
    public List<RoomRequestDTO> getAllRooms() {
        return objectDao.list()
                .parallelStream()
                .map(e -> mapper.mapToDTO((Room) e))
                .toList();
    }
    @Override
    public RoomRequestDTO getOneRoom(String name){
        return mapper.mapToDTO(
                objectDao.byName(name)
        );
    }
    //melo
    @Override
    public RoomRequestDTO createRoom(RoomRequestDTO room) {
        Room roomAb=mapper.mapToDTO(room);
        roomAb.setId(room.name()+room.campus());
        return mapper.mapToDTO(
                 objectDao.save(
                       roomAb
                ));
    }

    @Override
    public RoomRequestDTO updateRoom(String id, RoomRequestDTO room){
        Room roomUpdater=mapper.mapToDTO(room);
        roomUpdater.setId(id);
        return mapper.mapToDTO(
                objectDao.update(
                 id,roomUpdater
                ));
    }

    @Override
    public RoomRequestDTO activeChangeRoom(Boolean active, RoomRequestDTO roomRequestDTO) {
        Room room=mapper.mapToDTO(roomRequestDTO);
        room.setActive(active);
        return mapper.mapToDTO(objectDao.update(
                mapper.mapToDTO(roomRequestDTO).getId(),room));
    }
}

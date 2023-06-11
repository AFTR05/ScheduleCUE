package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomRequestDTO;

import java.util.List;

public interface RoomService {
    List<RoomRequestDTO> getAllRooms();

    RoomRequestDTO getOneRoom(String name);

    RoomRequestDTO createRoom(RoomInterfaceDTO room);

    RoomRequestDTO updateRoom(String id, RoomRequestDTO room);

    RoomRequestDTO activeChangeRoom(Boolean active, RoomRequestDTO roomRequestDTO);
}

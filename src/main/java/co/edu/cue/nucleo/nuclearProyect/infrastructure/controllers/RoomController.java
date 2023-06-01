package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.UpdateRoomRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.RoomService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService service;

    /**
     * Metodo que nos devuelve toda la lista de Salones
     * @return una Lista del Record DTO RoomRequestDTO
     */
    @GetMapping("/get-all")
    public List<RoomRequestDTO> getAllRooms() {
        return service.getAllRooms();
    }

    /**
     * Este metodo busca por un nombre
     * @param name : Es el nombre que que se pasa desde el Front
     * @return Record RoomRequestDTO
     */
    @GetMapping("/get-by-name/{name}")
    public RoomRequestDTO getRoomByName(@PathVariable
                                @Size(max = 20)
                                String name) {
        return service.getOneRoom(name);
    }

    /**
     * Este metodo agrega salones a la base de Datos
     * @param room: Es el salon que se desea crear
     * @return nos devuelve un  Record RoomRequestDTO
     */
    @PostMapping("/create")
    public RoomRequestDTO saveRoom(@RequestBody
                                           @Valid
                                           RoomRequestDTO room) {
        return service.createRoom(room);
    }

    /**
     * Este metodo
     * @param updateRoomRequestDTO
     * @return
     */
    @PutMapping("/update")
    public RoomRequestDTO updateRoom(@RequestBody
                                         @Valid   UpdateRoomRequestDTO updateRoomRequestDTO){
            return service.updateRoom(updateRoomRequestDTO.id(),updateRoomRequestDTO.roomRequestDTO());
    }
    @PutMapping("/changeActive")
    public RoomRequestDTO activeRoom(@RequestBody@Valid Boolean active, RoomRequestDTO roomRequestDTO){
        return service.activeChangeRoom(active,roomRequestDTO);

    }
}


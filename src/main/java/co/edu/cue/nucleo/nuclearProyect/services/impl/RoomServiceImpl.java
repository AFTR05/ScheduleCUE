package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomInterfaceDTO;
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
    private final ObjectDao<EquitmentRoom> equitmentDao;

    private final RoomMapper mapper;

    /**
     * Metodo que mapea una lista de Salones a un Record RoomRequestDTO
     * @return Record RoomRequestDTO
     */
    @Override
    public List<RoomRequestDTO> getAllRooms() {
        return objectDao.list()
                .parallelStream()
                .map(e -> mapper.mapToDTO((Room) e))
                .toList();
    }

    /**
     * Metodo que un salon por nombre y devuelve un Objeto RoomRequestDTO
     * @param name: Nombre que viene desde el ControllerRoom
     * @return record RoomRequestDTO
     */
    @Override
    public RoomRequestDTO getOneRoom(String name){
        return mapper.mapToDTO(
                objectDao.byName(name)
        );
    }

    /**
     * Metodo que mapea un RoomRequestDTO para almacenar un Room en
     * la base de datos para luego mapear otra vez delvolver un
     * record RoomRequestDTO
     * @param room: Es un DTO que contiene la Informacion del Salon
     * @return record RoomRequestDTO
     */
    @Override
    public RoomRequestDTO createRoom(RoomInterfaceDTO room) {
        Room roomAb=mapper.mapToEntity(new RoomRequestDTO(room.name(),room.campus(),room.capacity(),equitmentDao.byId(room.equitmentRoom()),true));
        roomAb.setId(room.name()+room.campus());
        return mapper.mapToDTO(
                 objectDao.save(
                       roomAb
                ));
    }

    /**
     * Metodo que actualiza un elemento en la base de datos por id ,
     * actualizandolo con un nuevo objeto
     * @param id: Id que nos sirve para hacer la busqueda
     * @param room: Record Dto que nos va ha servir para actualizar la base de Datos
     * @return un record RoomRequestDTO que es igual al mismo objeto que se
     * actualizo en la base de datos
     */
    @Override
    public RoomRequestDTO updateRoom(String id, RoomRequestDTO room){
        Room roomUpdater=mapper.mapToEntity(room);
        roomUpdater.setId(id);
        return mapper.mapToDTO(
                objectDao.update(
                 id,roomUpdater
                ));
    }

    /**
     * Este metodo activara o desactivara la disponibilidad de un Salon y
     * lo actualizara en la base de Datos
     * @param id: Nos sirve para identificar el salon
     * @param roomRequestDTO: objecto que actualizaremos en la base de Datos
     * @return un record RoomRequestDTO que actualizamos en la base de datos
     */
    @Override
    public RoomRequestDTO activeChangeRoom(String id,RoomRequestDTO roomRequestDTO) {
        Room room = mapper.mapToEntity(roomRequestDTO);
        room.setActive(!room.getActive());
        return mapper.mapToDTO(objectDao.update(
                id,room));
    }


}

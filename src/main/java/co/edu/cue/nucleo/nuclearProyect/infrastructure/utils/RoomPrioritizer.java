package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoomPrioritizer {
    public static Optional<List<Room>> getRoomNecessary(List<Room> rooms, Course course){
        List<Room> roomsSpecified=rooms.stream().filter(x->x.getEquitmentRoom().getId().equals(course.getEquitmentRoom().getId()))
                .collect(Collectors.toList());
        List<Room> activeRooms=roomsSpecified.stream().filter(x->x.getActive().equals(true)).collect(Collectors.toList());
        return Optional.of(activeRooms.stream().filter(x->x.getCapacity()>=course.getStudent().size()).collect(Collectors.toList()));
    }

    public static Optional<List<Room>> getRoomCampus(List<Room> rooms,Course course,String campus) {
        Optional<List<Room>> filterByNecessaryRoom = getRoomNecessary(rooms, course);
        return filterByNecessaryRoom.get().isEmpty()? Optional.empty() :Optional.of(filterByNecessaryRoom.get().stream()
                    .filter(x->x.getCampus().equals(campus))
                        .collect(Collectors.toList()));


    }
}

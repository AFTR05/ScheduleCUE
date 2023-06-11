package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;

public record RoomInterfaceDTO(String name, String campus, Integer capacity, String equitmentRoom, Boolean active){
}

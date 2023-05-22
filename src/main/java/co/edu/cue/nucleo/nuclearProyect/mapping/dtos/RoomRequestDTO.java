package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record RoomRequestDTO(String name,String campus,Integer capacity,EquitmentRoom equitmentRoom, Boolean active) {

}

package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Entity
public class Room {
    @Id
    private Integer id;
    private String name;
    private Integer capacity;
    private Boolean available;
    @ManyToOne
    @JoinColumn(name="equitment_room_id")
    private EquitmentRoom equitmentRoom;
    private Boolean active;
}

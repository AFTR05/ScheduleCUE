package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class  Room {
    @Id
    private String id;
    private String name;
    private String campus;
    private Integer capacity;
    @ManyToOne
    @JoinColumn(name="equitment_room_id")
    private EquitmentRoom equitmentRoom;
    private Boolean active;
}

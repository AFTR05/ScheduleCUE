package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@Entity
public class Modality { /*DAY("Diurno"), NIGHT("Nocturno");*/
    @Id
    private String id;
    @JoinColumn(name="name")
    @Column(name = "name")
    private String modality;

}

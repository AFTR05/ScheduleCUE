package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@Entity
public class Modality { /*DAY("Diurno"), NIGHT("Nocturno");*/
    @Id
    private String id;
    private String modality;

}

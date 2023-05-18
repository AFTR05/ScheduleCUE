package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Modality { DAY("Diurno"), NIGHT("Nocturno");
    private String modality;

}

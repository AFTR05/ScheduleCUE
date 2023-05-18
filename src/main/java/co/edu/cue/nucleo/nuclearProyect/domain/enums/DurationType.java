package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DurationType { TRIMESTRAL("Trimestral",12),SEMESTRAL("Semestral",24);
    private String type;
    private Integer weeks;
}

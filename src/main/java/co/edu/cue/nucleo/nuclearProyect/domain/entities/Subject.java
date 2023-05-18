package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.DurationType;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeSubject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private String id;
    private String name;
    private TypeSubject typeSubject;
    private DurationType durationType;
}

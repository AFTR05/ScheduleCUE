package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeSubject { CBU("Ciclo basico universitario"),AEL("Asignatura electiva")
                        ,AOP("Asignaturas optativas"),AOB("Asignaturas obligatorias");
    private String typeSubject;

}

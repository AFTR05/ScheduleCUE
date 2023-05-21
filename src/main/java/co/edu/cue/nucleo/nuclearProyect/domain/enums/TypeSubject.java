package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@Entity
public class TypeSubject {
    /*CBU("Ciclo basico universitario"),AEL("Asignatura electiva")
                        ,AOP("Asignaturas optativas"),AOB("Asignaturas obligatorias");*/
    @Id
    private Integer id;
    private String typeSubject;

}

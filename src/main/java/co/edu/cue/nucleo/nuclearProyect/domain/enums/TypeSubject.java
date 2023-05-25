package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@Entity
public class TypeSubject {
    /*CBU("Ciclo basico universitario"),AEL("Asignatura electiva")
                        ,AOP("Asignaturas optativas"),AOB("Asignaturas obligatorias");*/
    @Id
    private String id;
    @JoinColumn(name = "type")
    @Column(name="type")
    private String typeSubject;

}

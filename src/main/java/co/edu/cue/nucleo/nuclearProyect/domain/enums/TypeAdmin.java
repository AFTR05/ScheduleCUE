package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class TypeAdmin {
    /*COO("Coordinacion de programas"), DEC("Decanatura"),COL("Coodinacion de laboratorios");*/
    @Id
    @GeneratedValue(strategy    = GenerationType.IDENTITY)
    private String id;
    @JoinColumn(name = "type")
    @Column(name = "type")
    private String typeAdmin;

}

package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Data
@Entity
public class TypeAdmin {
    /*COO("Coordinacion de programas"), DEC("Decanatura"),COL("Coodinacion de laboratorios");*/
    @Id
    @GeneratedValue(strategy    = GenerationType.IDENTITY)
    private Integer id;
    private String typeAdmin;

}

package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeAdmin { COO("Coordinacion de programas"), DEC("Decanatura"),COL("Coodinacion de laboratorios");
    private String typeAdmin;

}

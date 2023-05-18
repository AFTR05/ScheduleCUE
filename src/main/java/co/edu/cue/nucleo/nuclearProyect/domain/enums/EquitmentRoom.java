package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EquitmentRoom { WITHALL("1",true,true,true,true,true),
    JUSTBOARDANDFAN("2",false,false,true,true,false),
    COMPUTERROOM("3",true,true,false,true,true),
    NORMALROOM("4",false,true,true,true,false);

    @Id
    private String id;
    private Boolean airConditioning;
    private Boolean projector;
    private Boolean fan;
    private Boolean board;
    private Boolean computer;

}

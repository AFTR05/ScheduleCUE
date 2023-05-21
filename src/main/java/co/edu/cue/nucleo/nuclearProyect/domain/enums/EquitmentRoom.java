package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class EquitmentRoom {

    /*WITHALL("1",true,true,true,true,true),
    JUSTBOARDANDFAN("2",false,false,true,true,false),
    COMPUTERROOM("3",true,true,false,true,true),
    NORMALROOM("4",false,true,true,true,false);*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Boolean airConditioning;
    private Boolean projector;
    private Boolean fan;
    private Boolean board;
    private Boolean computer;
    private Boolean camera;
    private Boolean lab;

}

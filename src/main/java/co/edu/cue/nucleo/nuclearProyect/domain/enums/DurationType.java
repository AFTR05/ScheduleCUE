package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class DurationType {

    /*TRIMESTRAL("Trimestral",12),SEMESTRAL("Semestral",24);*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private Integer weeks;
}

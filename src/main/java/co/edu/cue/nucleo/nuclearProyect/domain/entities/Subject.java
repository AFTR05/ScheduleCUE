package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.DurationType;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeSubject;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Subject {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name="type_subject_id")
    private TypeSubject typeSubject;
    @ManyToOne
    @JoinColumn(name="duration_type_id")
    private DurationType durationType;

    @Column(name = "count_semanal_hours")
    private Integer countSemanalHours;
}

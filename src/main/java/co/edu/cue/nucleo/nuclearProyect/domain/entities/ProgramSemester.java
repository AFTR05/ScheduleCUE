package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.Modality;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Entity
public class ProgramSemester {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="program_id")
    private Program program;

    private Integer semester;
    @ManyToOne
    @JoinColumn(name="modality_id")
    private Modality modality;
}

package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    String id;
    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule;
    @ManyToMany
    private List<Curse> curses;
    @ManyToOne
    @JoinColumn(name="progran_semester_id")
    private ProgramSemester ownSemester;
}

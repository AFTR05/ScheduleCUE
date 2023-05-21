package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Curse {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="duration_id")
    private Duration duration;
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;
    @OneToMany
    private List<RoomHour> roomHours;
    @OneToMany
    private List<Student> students;
    @ManyToOne
    @JoinColumn(name="program_id")
    private Program program;


}

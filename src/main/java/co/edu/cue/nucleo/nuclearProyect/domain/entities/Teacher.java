package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Teacher {
    @Id
    private String id;
    @ManyToMany
    private List<HourInterval> availability;
    @OneToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule;
    @OneToMany
    private List<Curse> curses;
}

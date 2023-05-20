package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Schedule {
    @Id
    private String id;
    @ManyToMany
    private List<Schedule> schedules;
}

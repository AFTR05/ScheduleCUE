package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Teacher extends User{
    @Id
    private String id;
    @ManyToMany
    private List<HourInterval> availability;
    @OneToMany
    private List<Curse> curses;

    public Teacher(String name, String email, String password, String id, List<HourInterval> availability,  List<Curse> curses) {
        super(name, email, password);
        this.id = id;
        this.availability = availability;
        this.curses = curses;
    }
}

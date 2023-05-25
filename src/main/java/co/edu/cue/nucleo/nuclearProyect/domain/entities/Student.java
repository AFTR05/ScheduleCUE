package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends User{
    @Id
    private String id;
    @ManyToMany
    private List<Curse> curses;
    @ManyToOne
    @JoinColumn(name="program_semester_id")
    private ProgramSemester ownSemester;


    public Student(String name, String email, String password, String id, List<Curse> curses, ProgramSemester ownSemester) {
        super(name, email, password);
        this.id = id;
        this.curses = curses;
        this.ownSemester = ownSemester;
    }
}

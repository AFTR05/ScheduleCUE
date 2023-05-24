package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

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
    private List<Course> courses;
    @ManyToOne
    @JoinColumn(name="progran_semester_id")
    private ProgramSemester ownSemester;


    public Student(String name, String email, String password, String id, List<Course> courses, ProgramSemester ownSemester) {
        super(name, email, password);
        this.id = id;
        this.courses = courses;
        this.ownSemester = ownSemester;
    }
}

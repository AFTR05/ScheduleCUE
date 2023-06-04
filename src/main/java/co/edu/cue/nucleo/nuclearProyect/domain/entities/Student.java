package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * Creación de la clase de Student que extiende de la clase de User
 *
* @author Juan Andrés Posdda
 */

public class Student{
    @Id
    private String id;
    private String name;
    @JoinColumn(name = "email_address")
    @Column(name = "email_address")
    private String email;
    private String password;
    @ManyToMany()
    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name="course_id")
    private List<Course> course;
    @ManyToOne
    @JoinColumn(name="program_semester_id")
    private ProgramSemester ownSemester;



}

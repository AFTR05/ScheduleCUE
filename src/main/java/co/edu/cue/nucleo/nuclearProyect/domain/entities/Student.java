package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student{
    @Id
    private String id;
    private String name;
    @JoinColumn(name = "email_address")
    @Column(name = "email_address")
    private String email;
    private String password;
    @ManyToMany()
    @JoinColumn(name="course_id")
    private List<Course> course;
    @ManyToOne
    @JoinColumn(name="program_semester_id")
    private ProgramSemester ownSemester;



}

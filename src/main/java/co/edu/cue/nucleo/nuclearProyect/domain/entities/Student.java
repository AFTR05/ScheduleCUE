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
    private String name;
    @JoinColumn(name = "email_address")
    @Column(name = "email_address")
    private String email;
    private String password;
    @Id
    private String id;
    @ManyToMany(mappedBy = "student")
    private List<Course> course;
    @ManyToOne
    @JoinColumn(name="progran_semester_id")
    private ProgramSemester ownSemester;



}

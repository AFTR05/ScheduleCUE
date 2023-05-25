package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Table(name = "teacher")
@Data
@Entity
@NoArgsConstructor
public class Teacher{

    @Id
    @Column (name = "id")
    private String id;
    private String name;
    @JoinColumn(name = "email_address")
    @Column(name = "email_address")
    private String email;
    private String password;
    @ManyToMany
    private List<HourInterval> interval;
    @OneToMany
    private List<Course> course;

}

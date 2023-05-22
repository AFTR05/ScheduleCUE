package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Table(name = "Teachers")
@Data
@Entity
@NoArgsConstructor
public class Teacher extends User{

    @Id
    @Column (name = "id")
    private String id;
    @ManyToMany
    private List<HourInterval> availability;
    @OneToMany
    private List<Course> courses;

    public Teacher(String name, String email, String password, String id, List<HourInterval> availability,  List<Course>courses) {
        super(name, email, password);
        this.id = id;
        this.availability = availability;
        this.courses= courses;
    }
}

package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Table(name = "teacher")
@Data
@Entity
@NoArgsConstructor
/**
 * Creación de la clase de Teacher que extiende de la clase de User
 *
 * @author Juan Andrés Posada
 */

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
    @JoinColumn(name = "hour_interval")
    @Column(name = "hour_interval_id")
    private List<HourInterval> hour_interval;

    @OneToMany(mappedBy = "teacher")
    private List<Course> course;

}

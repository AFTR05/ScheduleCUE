package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Table(name = "teacher")
@Getter
@Setter
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
    @ToString.Exclude
    @JoinColumn(name = "hour_interval")
    @Column(name = "hour_interval_id")
    private List<HourInterval> hour_interval;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy = "teacher")
    private List<Course> course;

}

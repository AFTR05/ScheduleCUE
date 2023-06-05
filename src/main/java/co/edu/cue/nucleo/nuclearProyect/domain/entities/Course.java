package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
public class Course {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="duration_id")
    private Duration duration;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude
    private List<RoomHour> hourRoom;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> student;
    @ManyToOne
    @JoinColumn(name="equitment_room_id")
    private EquitmentRoom equitmentRoom;

    @ManyToOne
    @JoinColumn(name="program_id")
    private Program program;


}

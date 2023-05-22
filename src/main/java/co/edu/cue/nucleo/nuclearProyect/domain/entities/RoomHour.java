package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class RoomHour {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="hour_interval_id")
    private HourInterval hourInterval;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

}

package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.*;

import java.time.LocalTime;

@Data
@Entity
public class HourInterval {
    @Id
    @Column(name = "id")
    @JoinColumn(name = "id")
    private Integer id;
    @Column(name = "begin_time")
    @JoinColumn(name = "begin_time")
    private LocalTime intervalBegin;
    @Column(name = "end_time")
    @JoinColumn(name = "end_time")
    private LocalTime intervalEnd;
    private String day;

}

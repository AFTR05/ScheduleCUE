package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalTime;

@Data
@Entity
public class HourInterval {
    @Id
    private Integer id;
    private LocalTime intervalBegin;
    private LocalTime intervalEnd;
    private String day;

}

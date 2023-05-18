package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HourInterval {
    private LocalTime intervalBegin;
    private LocalTime intervalEnd;
    private String day;

}

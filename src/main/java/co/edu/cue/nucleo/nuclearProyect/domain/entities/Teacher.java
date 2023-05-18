package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private List<HourInterval> availability;
    private Schedule schedule;
    private List<Curse> curses;
}

package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomHour {
    private HourInterval hourInterval;
    private Room room;
    private Curse curse;

}

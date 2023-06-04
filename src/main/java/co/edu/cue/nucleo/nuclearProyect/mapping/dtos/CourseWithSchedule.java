package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Duration;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.RoomHour;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;

import java.util.List;

public record CourseWithSchedule (Duration duration, Teacher teacher, Subject subject, Program program, EquitmentRoom equitmentRoom,
                                  List<RoomHour> hourRoom){
}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.RoomHour;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.DisponibilitySearcher;

public class CampusValidator {
    public static Boolean differentCampusValidation(RoomHour compareRoom,RoomHour roomHour){
        return compareRoom.getRoom().getCampus() != roomHour.getRoom().getCampus();
    }
}

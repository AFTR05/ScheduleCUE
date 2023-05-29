package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.Validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.RoomHour;

public class CampusValidator {
    public static Boolean differentCampusValidation(RoomHour compareRoom,RoomHour roomHour){
        return compareRoom.getRoom().getCampus() != roomHour.getRoom().getCampus();
    }
}

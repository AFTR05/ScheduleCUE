package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.RoomHour;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateTwoEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OperationFactory;

public class CampusValidator {

    public static Boolean differentCampusValidation(RoomHour compareRoom,RoomHour roomHour){
        return OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.DIFFERENTSTRING).test(compareRoom.getRoom().getCampus()
                ,roomHour.getRoom().getCampus());
        // compareRoom.getRoom().getCampus() != roomHour.getRoom().getCampus();
    }
}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.Validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;

import java.time.LocalTime;

public class TimeValidator {
    public static Boolean validateLunch(HourInterval hourInterval){
       return hourInterval.getIntervalBegin().compareTo(LocalTime.of(13,0))==0? false: true;
    }
}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;

import java.time.LocalTime;

public class TimeValidator {
    public static Boolean validateLunch(HourInterval hourInterval){
        LocalTime beginInterval = LocalTime.of(13,0,0);
        LocalTime endInterval = LocalTime.of(14,0,0);
        //inicio no puede ser >= 13 y inicio no puede ser < 14
        // end no puede ser > 13 y end no puede ser <=14
        return (hourInterval.getIntervalBegin().compareTo(beginInterval)>=0
                && hourInterval.getIntervalBegin().isBefore(endInterval))
                                ||
                (hourInterval.getIntervalEnd().isAfter(beginInterval) &&
                        hourInterval.getIntervalEnd().compareTo(endInterval)<=0);
    }

    public static Boolean validateScheduleOnDay(HourInterval hourInterval){
        LocalTime beginInterval = LocalTime.of(7,0,0);
        LocalTime endInterval = LocalTime.of(22,0,0);
        return (hourInterval.getIntervalBegin().compareTo(beginInterval)>=0
                && hourInterval.getIntervalBegin().isBefore(endInterval))
                ||
                (hourInterval.getIntervalEnd().isAfter(beginInterval) &&
                        hourInterval.getIntervalEnd().compareTo(endInterval)<=0);
    }
}

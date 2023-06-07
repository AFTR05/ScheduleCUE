package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateTwoEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OperationFactory;

import java.time.LocalTime;

public class TimeValidator {
    public static Boolean validateLunch(HourInterval hourInterval){
        LocalTime beginInterval = LocalTime.of(13,0,0);
        LocalTime endInterval = LocalTime.of(14,0,0);
        //inicio no puede ser >= 13 y inicio no puede ser < 14
        // end no puede ser > 13 y end no puede ser <=14
        return ((OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.MOREEQUAL).test(hourInterval.getIntervalBegin(),beginInterval)
        //hourInterval.getIntervalBegin().compareTo(beginInterval)>=0
              && OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.BEFORETIME).test(hourInterval.getIntervalBegin(),endInterval))
        //hourInterval.getIntervalBegin().isBefore(endInterval))
                                ||
                (OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.AFTERTIME).test(hourInterval.getIntervalEnd(),beginInterval)
                //(hourInterval.getIntervalEnd().isAfter(beginInterval)
                        &&
                OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.LESSEQUAL).test(hourInterval.getIntervalEnd(),endInterval)));
                //hourInterval.getIntervalEnd().compareTo(endInterval)<=0);
    }

    public static Boolean validateScheduleOnDay(HourInterval hourInterval){
        LocalTime beginInterval = LocalTime.of(7,0,0);
        LocalTime endInterval = LocalTime.of(22,0,0);
        return (OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.MOREEQUAL).test(hourInterval.getIntervalEnd(),beginInterval)
        //hourInterval.getIntervalBegin().compareTo(beginInterval)>=0
            && OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.BEFORETIME).test(hourInterval.getIntervalBegin(),endInterval))
        //hourInterval.getIntervalBegin().isBefore(endInterval))
                ||
                (OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.AFTERTIME).test(hourInterval.getIntervalEnd(),beginInterval)
                        &&
        //hourInterval.getIntervalEnd().isAfter(beginInterval)
          OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.LESSEQUAL).test(hourInterval.getIntervalEnd(),endInterval));
        //hourInterval.getIntervalEnd().compareTo(endInterval)<=0);
    }
}

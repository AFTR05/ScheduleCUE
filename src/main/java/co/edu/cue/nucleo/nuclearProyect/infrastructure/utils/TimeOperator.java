package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;

import java.util.Optional;

public class TimeOperator {
    public static Boolean isIn(HourInterval compareInterval, HourInterval hourInterval){
        if (compareInterval.getIntervalBegin().compareTo(hourInterval.getIntervalBegin())>=0 &&
                compareInterval.getIntervalEnd().compareTo(hourInterval.getIntervalBegin())<0){
            return true;
        }
        return false;
    }
    public static Boolean isBefore(HourInterval previousInterval, HourInterval actualInterval){
        if (previousInterval.getIntervalEnd().compareTo(actualInterval.getIntervalBegin())==0){
            return true;
        }
        return false;
    }

    public static Optional<HourInterval> additionInterval(HourInterval compareInterval, Integer hourInterval){ //generate the interval
        Integer d= Integer.parseInt(String.valueOf(compareInterval.getIntervalEnd().getHour()))-               // with countclass
                Integer.parseInt(String.valueOf(compareInterval.getIntervalBegin().getHour()));
        if(d>=hourInterval){
            return Optional.of(new HourInterval(compareInterval.getIntervalBegin(),compareInterval.getIntervalBegin().plusHours(hourInterval),compareInterval.getDay()));
        }
        return Optional.empty();
    }

    public static Optional<HourInterval> plusBoth(HourInterval compareInterval,HourInterval teacherInterval, Integer hourInterval){
        if (compareInterval.getIntervalEnd().isBefore(teacherInterval.getIntervalEnd()) &&
                compareInterval.getIntervalBegin().isAfter(teacherInterval.getIntervalBegin())){
            return Optional.of(new HourInterval(compareInterval.getIntervalBegin().plusHours(hourInterval)
                    ,compareInterval.getIntervalBegin().plusHours(hourInterval),compareInterval.getDay()));
        }
        return Optional.empty();
    }


    public static Optional<HourInterval> incrementOrigin(HourInterval compareInterval,Integer hourInterval){   //get foreward of time taking
        Integer d= Integer.parseInt(String.valueOf(compareInterval.getIntervalEnd().getHour()))-          //into account the countClass
                Integer.parseInt(String.valueOf(compareInterval.getIntervalBegin().getHour()));
        if(d>=hourInterval){
            return Optional.of(new HourInterval(compareInterval.getIntervalBegin().plusHours(hourInterval),compareInterval.getIntervalEnd(),compareInterval.getDay()));
        }
        return Optional.empty();
    }


}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateTwoParameterImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.PredicateTwoParameter;

import java.time.LocalTime;

public class MoreEqualTimeImp implements PredicateTwoParameter<LocalTime,LocalTime> {
    @Override
    public Boolean test(LocalTime value1, LocalTime value2) {
        return value1.compareTo(value2)>=0;
    }
}

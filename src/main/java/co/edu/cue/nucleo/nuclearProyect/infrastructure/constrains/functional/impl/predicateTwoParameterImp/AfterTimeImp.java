package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateTwoParameterImp;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.PredicateTwoParameter;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation.HoursValidation;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;

public class AfterTimeImp implements PredicateTwoParameter<LocalTime,LocalTime> {
    @Override
    public Boolean test(LocalTime value1, LocalTime value2) {
        return value1.isAfter(value2);
    }
}

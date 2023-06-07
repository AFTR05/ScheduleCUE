package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.RoomHour;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateTwoEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OperationFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DayValidation {
    public static Boolean validateCourseOnDay(Course course, String day){
        Optional<List<RoomHour>> dayRepeated=Optional.of(course.getHourRoom().stream()
                .filter(x->OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.DIFFERENTSTRING)
                        .test(x.getHourInterval().getDay(),day))
                            .collect(Collectors.toList()));
        return dayRepeated.get().isEmpty();
    }
}
//x->x.getHourInterval()
        //.getDay().equals(day)
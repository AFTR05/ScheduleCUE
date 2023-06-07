package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateTwoEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OperationFactory;

import java.util.List;

public class HoursValidation {
    public static Boolean validateWeeklyHours(Course course, List<Integer> hours) {
        return OperationFactory.getPredicateTwoParameter(PredicateTwoEnum.SAMENUMBER)
                .test(course.getHourRoom().size(),hours.size());
        //course.getHourRoom().size() == hours.size();
    }
}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;

import java.util.List;

public class HoursValidation {
    public static Boolean validateWeeklyHours(Course course, List<Integer> hours) {
        return course.getHourRoom().size() == hours.size();
    }
}

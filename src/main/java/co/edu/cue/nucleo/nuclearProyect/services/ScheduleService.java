package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseWithSchedule;

import java.util.List;

public interface ScheduleService {
        List<CourseWithSchedule> createSchedule();
}

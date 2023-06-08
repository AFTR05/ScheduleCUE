package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;

import java.util.List;

public record TeacherRequestDTO(String name, String email, String id, List<HourInterval> availability, List<Course>courses,Boolean active) {
}

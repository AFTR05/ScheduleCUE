package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.ProgramSemester;

import java.util.List;

public record StudentRequestDTO(String name, String email, String password, String id, List<Course> courses, ProgramSemester ownSemester) {
}

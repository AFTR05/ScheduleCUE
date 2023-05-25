package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.ProgramSemester;
import jakarta.persistence.*;

import java.util.List;

public record StudentRequestDTO(String name, String email, String password, List<Course> courses, ProgramSemester ownSemester) {

}

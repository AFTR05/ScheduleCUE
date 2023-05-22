package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.*;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;

public record CourseRequestDTO(Duration duration, Teacher teacher, Subject subject, Program program) {

}

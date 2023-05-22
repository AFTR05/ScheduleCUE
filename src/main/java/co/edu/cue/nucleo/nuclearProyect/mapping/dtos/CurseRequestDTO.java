package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.*;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public record CurseRequestDTO(Duration duration,Teacher teacher,Subject subject,Program program) {

}

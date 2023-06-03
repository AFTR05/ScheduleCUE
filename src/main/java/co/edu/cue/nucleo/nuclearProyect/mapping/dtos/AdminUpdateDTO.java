package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;

public record AdminUpdateDTO(AdminRequestDTO adminRequestDTO, String password) {
}

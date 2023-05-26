package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;

public record AdminRequestDTO(String name, String email, String password, TypeAdmin typeAdmin, String id) {
}

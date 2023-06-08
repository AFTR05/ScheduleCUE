package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;

public record AdminRequestDTO(String id,String name, String email, TypeAdmin typeAdmin, Boolean active) {
}

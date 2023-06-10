package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;

public record AdminInterfaceDTO (String id, String name, String email, String typeAdmin, Boolean active){
}

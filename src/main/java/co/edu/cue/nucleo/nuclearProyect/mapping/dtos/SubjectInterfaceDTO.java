package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.DurationType;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeSubject;

public record SubjectInterfaceDTO (String name, String typeSubject, String durationType, Integer countSemanalHours){
}

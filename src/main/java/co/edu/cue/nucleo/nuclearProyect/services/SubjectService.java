package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.SubjectInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.SubjectRequestDTO;

import java.util.List;

public interface SubjectService {
    List<SubjectRequestDTO> getAllSubjects();

    SubjectRequestDTO getOneSubject(String name);

    SubjectRequestDTO createSubject(SubjectInterfaceDTO subject);

    SubjectRequestDTO updateRoom(String id, SubjectRequestDTO subject);

}

package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.SubjectRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.SubjectMapper;
import co.edu.cue.nucleo.nuclearProyect.services.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImp implements SubjectService {
    private final ObjectDao<Subject> objectDao;

    private final SubjectMapper mapper;

    @Override
    public List<SubjectRequestDTO> getAllSubjects() {
        return objectDao.list()
                .parallelStream()
                .map(mapper::mapToDTO)
                .toList();
    }
    @Override
    public SubjectRequestDTO getOneSubject(String name){
        return mapper.mapToDTO(
                objectDao.byName(name)
        );
    }

    @Override
    public SubjectRequestDTO createSubject(SubjectRequestDTO subject) {
        Subject sub=mapper.mapToDTO(subject);
        sub.setId(subject.name()+subject.typeSubject().getId());
        return mapper.mapToDTO(
                objectDao.save(
                        sub
                ));
    }

    @Override
    public SubjectRequestDTO updateRoom(String id, SubjectRequestDTO subject){
        Subject subjectUpdater=mapper.mapToDTO(subject);
        subjectUpdater.setId(id);
        return mapper.mapToDTO(
                objectDao.update(
                        id,subjectUpdater
                ));
    }
}

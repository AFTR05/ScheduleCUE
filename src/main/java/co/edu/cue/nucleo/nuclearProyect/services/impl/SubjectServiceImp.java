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

    /**
     *Este metodo mapea una lista de Subjects a List<SubjectRequestDTO>.Es
     * para obtener toda la lista de materias de la universidad
     * @return List<SubjectRequestDTO>
     */
    @Override
    public List<SubjectRequestDTO> getAllSubjects() {
        return objectDao.list()
                .parallelStream()
                .map(mapper::mapToDTO)
                .toList();
    }

    /**
     * Este metodo busca por nombre en la base de datos
     * @param name: Parametro con el que vamos ha hacer la busqueda
     * por nombre
     * @return SubjectRequestDTO
     */
    @Override
    public SubjectRequestDTO getOneSubject(String name){
        return mapper.mapToDTO(
                objectDao.byName(name)
        );
    }

    /**
     * Con este metodo mapeamos un record SubjectRequestDTO a Subject
     * para almacenarlo en la base de datos
     * @param subject : objecto que vamos a mapear
     * @return record SubjectRequestDTO nuevo que se agrego en la base
     * de datos
     */
    @Override
    public SubjectRequestDTO createSubject(SubjectRequestDTO subject) {
        Subject sub=mapper.mapToDTO(subject);
        sub.setId(subject.name()+subject.typeSubject().getId());
        return mapper.mapToDTO(
                objectDao.save(
                        sub
                ));
    }

    /**
     * Este metodo actualiza un elemento de la base datos por su Id
     * @param id: id con el que vamos ha hacer la busqueda
     * @param subject: objecto que vamos ha reemplazar en la base de datos
     * @return un record SubjectRequestDTO
     */
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

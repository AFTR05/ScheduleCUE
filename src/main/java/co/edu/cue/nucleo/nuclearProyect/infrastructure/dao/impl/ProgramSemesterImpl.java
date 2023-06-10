package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.ProgramSemester;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Modality;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProgramSemesterImpl implements ObjectDao<ProgramSemester> {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<ProgramSemester> list() {
        return null;
    }

    @Override
    public ProgramSemester byId(String id) {
        return null;
    }

    @Override
    public ProgramSemester save(ProgramSemester programSemester) {
        return entityManager.merge(programSemester);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ProgramSemester update(String id, ProgramSemester programSemester) {
        return null;
    }

    @Override
    public ProgramSemester byName(String name) {
        return null;
    }

    public Optional<ProgramSemester> byProps(String modality,String semester,String program){
        try {
        Query query=entityManager.createQuery("select p from ProgramSemester p" +
                " where p.modality.modality=?1 and p.program.name=?2 and p.semester=?3", ProgramSemester.class);
        query.setParameter(1, modality);
        query.setParameter(2, program);
        query.setParameter(3, semester);
        query.setMaxResults(1);
            return Optional.of((ProgramSemester) query.getSingleResult());
        }catch(NoResultException ex){
            return Optional.empty();
        }
    }

    public void createWithAtt(Modality modality, String semester, Program program){
        Query query=entityManager.createNativeQuery("INSERT INTO `program_semester` (`id`, `program_id`, `semester`, `modality_id`) VALUES (?1, ?2, ?3, ?4)");
        query.setParameter(4, modality.getId());
        query.setParameter(3, semester);
        query.setParameter(2, program.getId());
        query.setParameter(1,program.getId()+modality.getId()+semester);
        query.executeUpdate();
    }
}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.ProgramSemester;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Modality;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.ProgramSemesterImpl;
import lombok.AllArgsConstructor;

import java.util.Optional;

public class SearchEntity {
    public static ProgramSemester getProgramSemester(String program,
                                                     String modality,
                                                     String semester,ObjectDao<Modality> modalityDao,ObjectDao<Program> programDao,
                                                     ProgramSemesterImpl programSemesterDao){
        Optional<ProgramSemester> ops=programSemesterDao.byProps(modality, semester, program);
        if (ops.isPresent()){
            return ops.get();
        }
        Modality mod=modalityDao.byName(modality);
        Program pro=programDao.byName(program);
        programSemesterDao.createWithAtt(mod,semester,pro);
        return programSemesterDao.byProps(mod.getModality(),semester,pro.getName()).get();
    }
}

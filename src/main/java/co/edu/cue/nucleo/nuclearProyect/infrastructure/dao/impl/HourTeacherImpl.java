package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Modality;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HourTeacherImpl {
    @PersistenceContext
    EntityManager entityManager;

    public void createWithAtt(HourInterval hourInterval, Teacher teacher){
        Query query=entityManager.createNativeQuery("INSERT INTO `teacher_hour_interval` " +
                "(`teacher_id`, `hour_interval_id`) VALUES (?1, ?2)");
        query.setParameter(1, teacher.getId());
        query.setParameter(2,hourInterval.getId());
        query.executeUpdate();
    }
}

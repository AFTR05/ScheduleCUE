package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.HourIntervalDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

@Repository
@Transactional
public class HourIntervalDaoImpl implements HourIntervalDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<HourInterval> byProps(String day, LocalTime begin, LocalTime end){
        try {
            Query query=entityManager.createQuery("select p from HourInterval p" +
                    " where p.day=?1 and p.intervalBegin=?2 and p.intervalEnd=?3", HourInterval.class);
            query.setParameter(1, day);
            query.setParameter(2, begin);
            query.setParameter(3, end);
            query.setMaxResults(1);
            return Optional.of((HourInterval) query.getSingleResult());
        }catch(NoResultException ex){
            return Optional.empty();
        }
    }
    @Override
    public void createWithNoID(String day, String begin, String end){
        Query query=entityManager.createNativeQuery("INSERT INTO `hour_interval` " +
                "(`day`, `begin_time`, `end_time`) VALUES (?1, ?2, ?3)");
        query.setParameter(1, day);
        query.setParameter(2, begin);
        query.setParameter(3, end);
        query.executeUpdate();
    }
}

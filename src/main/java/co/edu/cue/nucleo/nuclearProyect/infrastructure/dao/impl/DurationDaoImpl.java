package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Duration;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.ProgramSemester;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class DurationDaoImpl implements ObjectDao<Duration> {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Duration> list() {
        return null;
    }

    @Override
    public Duration byId(String id) {
        return null;
    }

    @Override
    public Duration save(Duration duration) {
        return entityManager.merge(duration);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Duration update(String id, Duration duration) {
        return null;
    }

    @Override
    public Duration byName(String name) {
        return null;
    }
    public Optional<Duration> byProps(LocalDate begin, LocalDate end){
        try {
            Query query=entityManager.createQuery("select p from Duration p" +
                    " where p.begin=?1 and p.end=?2", Duration.class);
            query.setParameter(1, begin);
            query.setParameter(2, end);
            query.setMaxResults(1);
            return Optional.of((Duration) query.getSingleResult());
        }catch(NoResultException ex){
            return Optional.empty();
        }
    }

}

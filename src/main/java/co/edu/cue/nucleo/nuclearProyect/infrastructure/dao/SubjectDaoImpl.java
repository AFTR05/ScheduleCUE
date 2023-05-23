package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SubjectDaoImpl implements SubjectDao{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void createSubject(Subject subject) {
        entityManager.merge(subject);
    }

    @Override
    public void deleteSubject(Long id) {
       User user = entityManager.find(User.class,id);
       entityManager.remove(user);
    }
}

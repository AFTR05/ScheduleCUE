package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;

public interface SubjectDao {
    void createSubject(Subject subject);
    void deleteSubject(Long id);
}

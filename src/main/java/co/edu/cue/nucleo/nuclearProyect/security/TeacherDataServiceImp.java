package co.edu.cue.nucleo.nuclearProyect.security;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;

public class TeacherDataServiceImp implements UserDataService<Teacher> {
    ObjectDao<Teacher> dao;
    @Override
    public Teacher geyByName(String name) {
        return dao.byName(name);
    }
}

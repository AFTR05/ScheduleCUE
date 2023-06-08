package co.edu.cue.nucleo.nuclearProyect.security;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;

public class AdminDataServiceImp implements UserDataService<Administrator> {

    ObjectDao<Administrator> dao;
    @Override
    public Administrator geyByName(String name) {
        return dao.byName(name);
    }
}

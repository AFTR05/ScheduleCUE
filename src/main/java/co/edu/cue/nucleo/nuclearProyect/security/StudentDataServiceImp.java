package co.edu.cue.nucleo.nuclearProyect.security;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;

public class StudentDataServiceImp implements UserDataService<Student>{

    ObjectDao<Student> dao;
    @Override
    public Student geyByName(String name) {
        return dao.byName(name);
    }
}

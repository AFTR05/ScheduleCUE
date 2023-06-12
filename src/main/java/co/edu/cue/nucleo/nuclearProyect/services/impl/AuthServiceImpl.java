package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.AdminDaoImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.StudentDaoImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.TeacherDaoImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.AuthLogin;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.LoginRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    StudentDaoImpl studentDao;
    TeacherDaoImpl teacherDao;
    AdminDaoImpl adminDao;

    @Override
    public String login(LoginRequestDTO loginRequestDTO){
        Optional<Student> s=studentDao.byCredenciales(loginRequestDTO.id(), loginRequestDTO.password());
        Optional<Administrator> a=adminDao.byCredenciales(loginRequestDTO.id(), loginRequestDTO.password());
        Optional<Teacher> t=teacherDao.byCredenciales(loginRequestDTO.id(), loginRequestDTO.password());
        return AuthLogin.authLogin(s,t,a);
    }
}

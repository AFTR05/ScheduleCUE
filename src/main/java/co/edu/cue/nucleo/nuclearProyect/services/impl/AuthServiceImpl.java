package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.AuthLogin;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.LoginRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    ObjectDao<Student> studentDao;
    ObjectDao<Teacher> teacherDao;
    ObjectDao<Administrator> adminDao;

    @Override
    public Optional login(LoginRequestDTO loginRequestDTO){
        String option=AuthLogin.getAuth(loginRequestDTO,adminDao.list(),studentDao.list(),teacherDao.list());
        return AuthLogin.getLoginRequest(option,loginRequestDTO,adminDao.list(),studentDao.list(), teacherDao.list());
    }
}

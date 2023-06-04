package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.TeacherMapper;
import co.edu.cue.nucleo.nuclearProyect.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TeacherServiceImpl implements TeacherService {
    private final ObjectDao<Teacher> objectDao;
    private final TeacherMapper mapper;
    @Override
    public List<TeacherRequestDTO> getAllTeachers() {
        List<Teacher> sis=objectDao.list();
        return objectDao.list()
                .stream()
                .map(e -> mapper.mapToDTO((Teacher) e))
                .toList();
    }

    @Override
    public TeacherRequestDTO createTeacher(TeacherRequestDTO teacher) {
        Teacher teacherAb=mapper.mapToDTO(teacher);
        teacherAb.setPassword(teacher.id());
        return mapper.mapToDTO(
                objectDao.save(teacherAb
                ));
    }

    @Override
    public TeacherRequestDTO getOneTeacher(String id){
        return mapper.mapToDTO(
                objectDao.byId(id));
    }
    @Override
    public TeacherRequestDTO updateTeacher(TeacherRequestDTO teacher, String password) {
        Teacher t=mapper.mapToDTO(teacher);
        return mapper.mapToDTO(objectDao.update(password,t));
    }
}

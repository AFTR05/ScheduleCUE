package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.StudentRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.StudentMapper;
import co.edu.cue.nucleo.nuclearProyect.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final ObjectDao<Student> objectDao;
    private final StudentMapper mapper;
    @Override
    public List<StudentRequestDTO> getAllStudents() {
        return objectDao.list()
                .stream()
                .map(e -> mapper.mapToDTO((Student) e))
                .toList();
    }
    @Override
    public StudentRequestDTO getOneStudent(String id){
        return mapper.mapToDTO(
                objectDao.byId(id));
    }

    @Override
    public StudentRequestDTO createStudent(StudentRequestDTO student) {
        Student studentAb=mapper.mapToEntity(student);
        studentAb.setPassword(student.id());
        return mapper.mapToDTO(
                objectDao.save(studentAb
                ));
    }

    @Override
    public StudentRequestDTO updateStudent(String password,StudentRequestDTO student) {
        return mapper.mapToDTO(objectDao.update(password,mapper.mapToEntity(student)));
    }
}

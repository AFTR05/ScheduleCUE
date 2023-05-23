package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
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
                .parallelStream()
                .map(e -> mapper.mapToDTO((Student) e))
                .toList();
    }

    @Override
    public StudentRequestDTO createStudent(StudentRequestDTO student) {
        Student studentAb=mapper.mapToDTO(student);
        studentAb.setId(student.name());
        return mapper.mapToDTO(
                objectDao.save(studentAb
                ));
    }

    @Override
    public StudentRequestDTO updateStudent(String id, StudentRequestDTO student) {
        Student studentUp=mapper.mapToDTO(student);
        studentUp.setId(id);
        return mapper.mapToDTO(objectDao.update(id,studentUp));
    }
}

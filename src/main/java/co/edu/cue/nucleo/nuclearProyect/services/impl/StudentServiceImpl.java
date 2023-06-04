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
     /**
         * Devuelve una lista de todos los estudiantes.
         *
         * @return Lista de objetos StudentRequestDTO que representan a los estudiantes.
         */
    @Override
    public List<StudentRequestDTO> getAllStudents() {
        return objectDao.list()
                .stream()
                .map(e -> mapper.mapToDTO((Student) e))
                .toList();
    }
    /**
         * Obtiene un estudiante basado en el ID proporcionado.
         *
         * @param id ID del estudiante a buscar.
         * @return Objeto StudentRequestDTO que representa al estudiante encontrado.
         */
    @Override
    public StudentRequestDTO getOneStudent(String id){
        return mapper.mapToDTO(
                objectDao.byId(id));
    }
        /**
         * Crea un nuevo estudiante.
         *
         * @param student Objeto StudentRequestDTO que contiene los detalles del estudiante a crear.
         * @return Objeto StudentRequestDTO que representa al estudiante creado.
         */
    @Override
    public StudentRequestDTO createStudent(StudentRequestDTO student) {
        Student studentAb=mapper.mapToEntity(student);
        studentAb.setPassword(student.id());
        return mapper.mapToDTO(
                objectDao.save(studentAb
                ));
    }
        /**
         * Actualiza un estudiante existente.
         *
         * @param password Contraseña requerida para realizar la actualización.
         * @param student  Objeto StudentRequestDTO que contiene los detalles actualizados del estudiante.
         * @return Objeto StudentRequestDTO que representa al estudiante actualizado.
         */

    @Override
    public StudentRequestDTO updateStudent(String password,StudentRequestDTO student) {
        return mapper.mapToDTO(objectDao.update(password,mapper.mapToEntity(student)));
    }
}

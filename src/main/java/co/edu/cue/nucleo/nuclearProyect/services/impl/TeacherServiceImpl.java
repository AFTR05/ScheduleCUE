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

        /**
         * Obtiene una lista de todos los profesores.
         *
         * @return Lista de objetos TeacherRequestDTO que representan a los profesores.
         */
    @Override
    public List<TeacherRequestDTO> getAllTeachers() {
        List<Teacher> teachers=objectDao.list();
        return objectDao.list()
                .stream()
                .map(e -> mapper.mapToDTO((Teacher) e))
                .toList();
    }

        /**
         * Crea un nuevo profesor.
         *
         * @param teacher Objeto TeacherRequestDTO que contiene los detalles del profesor a crear.
         * @return Objeto TeacherRequestDTO que representa al profesor creado.
         */
    @Override
    public TeacherRequestDTO createTeacher(TeacherRequestDTO teacher) {
        Teacher teacherAb=mapper.mapToEntity(teacher);
        teacherAb.setPassword(teacher.id());
        return mapper.mapToDTO(
                objectDao.save(teacherAb
                ));
    }

        /**
         * Obtiene un profesor basado en el ID proporcionado.
         *
         * @param id ID del profesor a buscar.
         * @return Objeto TeacherRequestDTO que representa al profesor encontrado.
         */

    @Override
    public TeacherRequestDTO getOneTeacher(String id){
        return mapper.mapToDTO(
                objectDao.byId(id));
    }

        /**
         * Actualiza un profesor existente.
         *
         * @param teacher  Objeto TeacherRequestDTO que contiene los detalles actualizados del profesor.
         * @param password Contraseña requerida para realizar la actualización.
         * @return Objeto TeacherRequestDTO que representa al profesor actualizado.
         */
    @Override
    public TeacherRequestDTO updateTeacher(TeacherRequestDTO teacher, String password) {
        Teacher t=mapper.mapToEntity(teacher);
        return mapper.mapToDTO(objectDao.update(password,t));
    }
}

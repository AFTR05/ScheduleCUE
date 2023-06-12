package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.ProgramSemester;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Modality;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.ProgramSemesterImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.SearchEntity;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.StudentInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.StudentRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.StudentUpdateInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.StudentMapper;
import co.edu.cue.nucleo.nuclearProyect.services.StudentService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final ObjectDao<Student> objectDao;
    private final ObjectDao<Program> programDao;
    private final ObjectDao<Modality> modalityDao;
    private final ProgramSemesterImpl programSemesterDao;
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
        public StudentRequestDTO createStudent(StudentInterfaceDTO student) {
            ProgramSemester ps=SearchEntity.getProgramSemester(student.program(),student.modality(),student.semester(),modalityDao,programDao,programSemesterDao);
            Student studentAb=mapper.mapToEntity(new StudentRequestDTO(student.id(),student.name(),student.active(),student.email()
                    ,student.id(), new ArrayList<>(),ps));
            Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            String hash=argon2.hash(1,1024,1,studentAb.getId());
            studentAb.setPassword(hash);
            return mapper.mapToDTO(
                    objectDao.save(studentAb
                    ));
        }

        /**
         * Actualiza un estudiante existente.
         *
         * @param student  Objeto StudentRequestDTO que contiene los detalles actualizados del estudiante.
         * @return Objeto StudentRequestDTO que representa al estudiante actualizado.
         */

    @Override
    public StudentRequestDTO updateStudent(StudentUpdateInterfaceDTO student) {
        Student s=objectDao.byId(student.id());
        return mapper.mapToDTO(objectDao.update(student.newPassword(),s));
    }
}

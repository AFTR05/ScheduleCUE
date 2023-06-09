package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.HourIntervalDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.HourTeacherImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.SearchEntity;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.HourIntervalDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.HourIntervalInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherUpdateInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.TeacherMapper;
import co.edu.cue.nucleo.nuclearProyect.services.TeacherService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class TeacherServiceImpl implements TeacherService {
    private final ObjectDao<Teacher> objectDao;
    private final HourTeacherImpl hourTeacherDao;
    private final HourIntervalDao hourIntervalDao;
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
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash=argon2.hash(1,1024,1,teacherAb.getId());
        teacherAb.setPassword(hash);
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
         * @return Objeto TeacherRequestDTO que representa al profesor actualizado.
         */
    @Override
    public TeacherRequestDTO updateTeacher(TeacherUpdateInterfaceDTO teacher) {
        Teacher t=objectDao.byId(teacher.id());
        return mapper.mapToDTO(objectDao.update(teacher.newPassword(), t));
    }

    @Override
    public List<HourIntervalDTO> getDisponibility(String id){
        TeacherRequestDTO teacher=getOneTeacher(id);
        List<HourIntervalDTO> hidtos=new ArrayList<>();
        for (HourInterval h:teacher.availability()) {
            hidtos.add(new HourIntervalDTO(h.getDay(),h.getIntervalBegin().toString(),h.getIntervalEnd().toString()));
        }
        return hidtos;
    }

    @Override
    public HourIntervalDTO addDisponibility(HourIntervalInterfaceDTO hourIntervalInterfaceDTO){
        HourInterval hi=SearchEntity.getHourInterval(hourIntervalInterfaceDTO.day(), LocalTime.of(hourIntervalInterfaceDTO.begin(),0)
                , LocalTime.of(hourIntervalInterfaceDTO.end(),0),hourIntervalDao);
        hourTeacherDao.createWithAtt(hi,objectDao.byId(hourIntervalInterfaceDTO.id()));
        return new HourIntervalDTO(hi.getDay(),hi.getIntervalBegin().toString(),hi.getIntervalEnd().toString());
    }

    @Override
    public void desactive(String id) {
        Teacher teacher = objectDao.byId(id);
        teacher.setActive(false);
        objectDao.save(teacher);
    }

    @Override
    public TeacherRequestDTO updateTeacherData(TeacherRequestDTO teacherRequestDTO) {
        System.out.println(teacherRequestDTO.toString());
        Teacher teacher = objectDao.byId(teacherRequestDTO.id());
        teacher.setName(teacherRequestDTO.name());
        teacher.setEmail(teacherRequestDTO.email());
        return mapper.mapToDTO(objectDao.save(teacher));
    }

}

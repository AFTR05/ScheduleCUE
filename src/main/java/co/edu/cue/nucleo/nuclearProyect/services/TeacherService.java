package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.HourIntervalDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.HourIntervalInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherUpdateInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.security.TeacherDataServiceImp;

import java.util.List;

public interface TeacherService {
    List<TeacherRequestDTO> getAllTeachers();
    TeacherRequestDTO createTeacher(TeacherRequestDTO teacher);

    TeacherRequestDTO getOneTeacher(String id);

    TeacherRequestDTO updateTeacher(TeacherUpdateInterfaceDTO teacherUpdateInterfaceDTO);

    List<HourIntervalDTO> getDisponibility(String id);

    HourIntervalDTO addDisponibility(HourIntervalInterfaceDTO hourIntervalInterfaceDTO);

    void desactive(String id);

    TeacherRequestDTO updateTeacherData(TeacherRequestDTO teacherRequestDTO);
}

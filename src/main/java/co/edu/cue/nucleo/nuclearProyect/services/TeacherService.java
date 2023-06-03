package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherRequestDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherRequestDTO> getAllTeachers();
    TeacherRequestDTO createTeacher(TeacherRequestDTO teacher);

    TeacherRequestDTO getOneTeacher(String id);

    TeacherRequestDTO updateTeacher(TeacherRequestDTO teacher, String password);
}

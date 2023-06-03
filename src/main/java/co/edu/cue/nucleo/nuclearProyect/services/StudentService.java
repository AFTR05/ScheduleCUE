package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.StudentRequestDTO;

import java.util.List;

public interface StudentService {
    List<StudentRequestDTO> getAllStudents();
        StudentRequestDTO getOneStudent(String id);

    StudentRequestDTO createStudent(StudentRequestDTO student);

    StudentRequestDTO updateStudent( String password,StudentRequestDTO student);
}

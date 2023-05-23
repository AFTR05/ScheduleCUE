package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.StudentRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.UpdateStudentRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;
    @GetMapping("/get-all")
    public List<StudentRequestDTO> getAllStudents(){
        return service.getAllStudents();
    }
    @PostMapping("/create")
    public StudentRequestDTO createStudent(@RequestBody
                                           @Valid
                                           StudentRequestDTO student){
        return service.createStudent(student);
    }
    @PutMapping("/update")
    public StudentRequestDTO updateStudent(@RequestBody
                                           @Valid
                                           UpdateStudentRequestDTO updateStudentRequestDTO){
        return service.updateStudent(updateStudentRequestDTO.id(),updateStudentRequestDTO.studentRequestDTO());
    }

}

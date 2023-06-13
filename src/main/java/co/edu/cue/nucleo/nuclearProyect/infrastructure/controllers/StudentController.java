package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.*;
import co.edu.cue.nucleo.nuclearProyect.services.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student_ad")
public class StudentController {

    private final StudentService service;
    @GetMapping("/get-all")
    public List<StudentRequestDTO> getAllStudents(){
        return service.getAllStudents();
    }
    @PostMapping("/create")
    public StudentRequestDTO createStudent(@RequestBody
                                           @Valid
                                           StudentInterfaceDTO student){
        return service.createStudent(student);
    }

    @GetMapping("/get-by-id/{id}")
    public StudentRequestDTO getRoomByName(@PathVariable
                                         @Size(max = 20)
                                         String id) {
        return service.getOneStudent(id);
    }
    @PutMapping("/update")
    public StudentRequestDTO updateStudent(@RequestBody
                                           @Valid
                                           StudentUpdateInterfaceDTO studentUpdateInterfaceDTO){
        return service.updateStudent(studentUpdateInterfaceDTO);
    }


    @PutMapping("/update-data-student")
    public StudentRequestDTO updateDataStudent(@RequestBody StudentUpdateRequestDTO studentUpdateRequestDTO){
        return service.updateStudentData(studentUpdateRequestDTO);
    }
    @PutMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable String id){
        service.desactiveStudent(id);
    }
}

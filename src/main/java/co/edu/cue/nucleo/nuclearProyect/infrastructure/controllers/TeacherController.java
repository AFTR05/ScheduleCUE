package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.TeacherUpdateInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.UpdateTeacherRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.TeacherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/teacher_ad")
public class TeacherController {
    private final TeacherService service;
    @GetMapping("/get-all")
    public List<TeacherRequestDTO> getAllTeachers(){
        return service.getAllTeachers();
    }
    @PostMapping("/create")
    public TeacherRequestDTO createTeacher(@RequestBody
                                           @Valid
                                           TeacherRequestDTO teacher){
        return service.createTeacher(teacher);
    }
    @PutMapping("/update")
    public TeacherRequestDTO updateTeacher(@RequestBody
                                           @Valid
                                           TeacherUpdateInterfaceDTO updateTeacher){
        return service.updateTeacher(updateTeacher);
    }

    @GetMapping("/get-by-id/{id}")
    public TeacherRequestDTO getById(@PathVariable
                                         @Size(max = 20)
                                         String id){
        return service.getOneTeacher(id);
    }
}

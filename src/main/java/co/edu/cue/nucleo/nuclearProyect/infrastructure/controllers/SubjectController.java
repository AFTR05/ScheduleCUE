package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.SubjectRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.SubjectUpdateDTO;
import co.edu.cue.nucleo.nuclearProyect.services.SubjectService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/subject_ad")
public class SubjectController {
    private final SubjectService service;

    @GetMapping("/get-all")
    public List<SubjectRequestDTO> getAllSubjects() {
        return service.getAllSubjects();
    }

    @GetMapping("/get-by-name/{name}")
    public SubjectRequestDTO getRoomByName(@PathVariable
                                        @Size(max = 20)
                                        String name) {
        return service.getOneSubject(name);
    }

    @PostMapping("/create")
    public SubjectRequestDTO saveSubject(@RequestBody
                                   @Valid
                                   SubjectRequestDTO subject) {
        return service.createSubject(subject);
    }
    @PutMapping("/update")
    public SubjectRequestDTO updateRoom(@RequestBody
                                     @Valid
                                     SubjectUpdateDTO subjectUpdateDTO){
        return service.updateRoom(subjectUpdateDTO.id(),subjectUpdateDTO.subjectRequestDTO());
    }

}

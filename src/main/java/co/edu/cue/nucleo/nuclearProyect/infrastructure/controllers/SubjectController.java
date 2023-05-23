package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.SubjectDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/subject")
public class SubjectController {
    SubjectDao subjectDao;
    @PostMapping("/create")
    public void createSubject(@RequestBody Subject subject){
        subjectDao.createSubject(subject);
    }

    @GetMapping("/delete/{id}")
    public void deleteSubject(@PathVariable Long id){
        subjectDao.deleteSubject(id);
    }

}

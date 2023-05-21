package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {
    @GetMapping("/prove")
    public String prove(){
        return "prove teacher";
    }
}

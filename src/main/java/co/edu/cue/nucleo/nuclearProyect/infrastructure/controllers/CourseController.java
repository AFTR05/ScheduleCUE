package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/curse")
public class CourseController {
    @GetMapping("/prove")
    public String prove(){
        return "prove curse";
    }
}

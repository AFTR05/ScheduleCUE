package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class AdminController {
    @RequestMapping(value = "prueba")
    public String prueba(){
        return "prueba";
    }
}

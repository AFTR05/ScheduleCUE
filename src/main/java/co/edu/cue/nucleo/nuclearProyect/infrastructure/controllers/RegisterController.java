package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping ("/registro")
        public String showFormRegister(){
        return "EjemploRegistro.html";
    }

}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ShowController {
    @GetMapping("/registro")
    public String showFormRegister(){
        return "EjemploRegistro";
    }

    @GetMapping({"/login","/"})
    public String showLogin(){
        return "login";
    }
    @GetMapping("/student")
    public String showStudent(){
        return "student/student";
    }
    @GetMapping("/teacher")
    public String showTeacher(){
        return "teacher/teacher";
    }
    @GetMapping("/admin")
    public String showAdmin(){
        return "admin/admin";
    }

}


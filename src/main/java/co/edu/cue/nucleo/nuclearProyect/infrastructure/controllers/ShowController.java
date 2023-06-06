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
        return "student";
    }
    @GetMapping("/teacher")
    public String showTeacher(){
        return "teacher";
    }
    @GetMapping("/admin")
    public String showAdmin(){
        return "admin";
    }

    @GetMapping("/admin/courses")
    public String showAdminCourses(){
        return "admin-courses";
    }

    @GetMapping("/admin/teachers")
    public String showAdminTeachers(){
        return "admin-teachers";
    }

    @GetMapping("/admin/students")
    public String showAdminStudents(){
        return "admin-students";
    }

    @GetMapping("/admin/rooms")
    public String showAdminRooms(){
        return "admin-rooms";
    }

    @GetMapping("/admin/subjects")
    public String showAdminSubject(){
        return "admin-subjects";
    }

    @GetMapping("/admin/reserve")
    public String showAdminReserve(){
        return "admin-reserve";
    }
}


package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.AuthLogin;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.LoginRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AuthController {
    AuthService service;
    @PostMapping("/login")
    public String login(@RequestParam("id-user") String id, @RequestParam("password") String password, Model model){
        Optional object=service.login(new LoginRequestDTO(id, password));
        Administrator administrator=(Administrator) object.get();
        if (object.isPresent())model.addAttribute("usuario",object.get());
        return AuthLogin.getTypeString(object.get());
    }
}

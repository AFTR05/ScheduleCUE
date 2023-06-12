package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AuthDataDTO;
import co.edu.cue.nucleo.nuclearProyect.security.JWTUtil;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.LoginRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    AuthService service;
    JWTUtil jwtUtil;
    @PostMapping("/login")
    public AuthDataDTO login(@RequestBody @Valid LoginRequestDTO loginRequestDTO){
        String object=service.login(loginRequestDTO);
        if (!object.equals("no")) {
            String tokenJwt = jwtUtil.create(loginRequestDTO.id(), object);
            return new AuthDataDTO(tokenJwt,object, loginRequestDTO.id());
        }
        return new AuthDataDTO("FAIL",object,"");
    }
}

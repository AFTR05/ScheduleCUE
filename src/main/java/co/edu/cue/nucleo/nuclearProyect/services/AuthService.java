package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.LoginRequestDTO;

import java.util.Optional;

public interface AuthService {
   String login(LoginRequestDTO loginRequestDTO);
}

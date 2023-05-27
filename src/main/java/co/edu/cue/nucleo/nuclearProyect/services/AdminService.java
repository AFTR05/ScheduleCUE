package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminUpdateDTO;

import java.util.List;

public interface AdminService {
    List<AdminRequestDTO> getAllAdmins();

    AdminRequestDTO getOneAdmin(String id);

    AdminRequestDTO createAdmin(AdminRequestDTO admin);


    AdminRequestDTO updateAdmin(AdminRequestDTO admin, String password);
}

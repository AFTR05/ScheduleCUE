package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminUpdateDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminUpdateInterfaceDTO;

import java.util.List;

public interface AdminService {
    List<AdminRequestDTO> getAllAdmins();

    AdminRequestDTO getOneAdmin(String id);

    AdminRequestDTO createAdmin(AdminInterfaceDTO admin);


    AdminRequestDTO updateAdmin(AdminUpdateInterfaceDTO admin);

    AdminRequestDTO updateDataAdmin(AdminInterfaceDTO adminInterfaceDTO);

    void desactiveAdmin(String id);
}

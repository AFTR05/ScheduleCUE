package co.edu.cue.nucleo.nuclearProyect.services;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;

import java.util.List;

public interface AdminService {
    List<AdminRequestDTO> getAllAdmins();
    AdminRequestDTO createAdmin(AdminRequestDTO admin);
    AdminRequestDTO updateAdmin(String id, AdminRequestDTO admin);
}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.UpdateAdminRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @GetMapping("/get-all")
    public List<AdminRequestDTO> getAllAdmins(){
        return adminService.getAllAdmins();
    }
@PostMapping("/create")
    public AdminRequestDTO createAdmin(@RequestBody
                                       @Valid
                                       AdminRequestDTO admin){
        return adminService.createAdmin(admin);
}
@PutMapping("/update")
    public AdminRequestDTO updateAdmin(@RequestBody
                                       @Valid
                                       UpdateAdminRequestDTO updateAdminRequestDTO){
        return adminService.updateAdmin(updateAdminRequestDTO.id(),updateAdminRequestDTO.adminRequestDTORequestDTO());
}
}

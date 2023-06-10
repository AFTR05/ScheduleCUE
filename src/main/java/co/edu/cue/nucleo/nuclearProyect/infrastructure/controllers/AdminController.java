package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminUpdateDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.AdminService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin_ad")
public class AdminController {
    private final AdminService service;
    @GetMapping("/get-all")
    public List<AdminRequestDTO> getAllAdmins(){
        return service.getAllAdmins();
    }
    @GetMapping("/get-by-id/{id}")
    public AdminRequestDTO getRoomByName(@PathVariable
                                        @Size(max = 20)
                                        String id) {
        return service.getOneAdmin(id);
    }
    @PostMapping("/create")
    public AdminRequestDTO createAdmin(@RequestBody
                                       @Valid
                                       AdminRequestDTO admin){ return service.createAdmin(admin);}
    @PutMapping("/update")
    public AdminRequestDTO updateAdmin(@RequestBody
                                       @Valid
                                       AdminUpdateDTO adminUpdateDTO){
        return service.updateAdmin(adminUpdateDTO.adminRequestDTO(), adminUpdateDTO.password());}

}



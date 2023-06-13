package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.*;
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
                                       AdminInterfaceDTO admin){ return service.createAdmin(admin);}
    @PutMapping("/update")
    public AdminRequestDTO updateAdmin(@RequestBody
                                       @Valid
                                       AdminUpdateInterfaceDTO adminUpdateDTO){
        return service.updateAdmin(adminUpdateDTO);}

    @PutMapping("/update-data-admin")
    public AdminRequestDTO updateDataAdmin(@RequestBody AdminInterfaceDTO adminInterfaceDTO){
        return service.updateDataAdmin(adminInterfaceDTO);
    }

    @PutMapping("/delete-admin/{id}")
    public void deleteAdmin(@PathVariable String id){
        service.desactiveAdmin(id);
    }

}



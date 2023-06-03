package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.CourseService;
import co.edu.cue.nucleo.nuclearProyect.services.ScheduleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {
    ScheduleService service;
    @PutMapping("/create-schedule")
    public List<CourseRequestDTO> createSchedule(){
        return service.createSchedule();
    }
}

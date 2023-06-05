package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.RoomRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.UpdateCourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.UpdateRoomRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.services.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/course_ad")
public class CourseController {
    CourseService service;
    @GetMapping("/get-all")
    public List<CourseRequestDTO> getAllRooms() {
        return service.getAllCourses();
    }

    @GetMapping("/get-by-name/{name}")
    public CourseRequestDTO getRoomByName(@PathVariable
                                        @Size(max = 20)
                                        String name) {
        return service.getOneCourse(name);
    }

    @PostMapping("/create")
    public CourseRequestDTO saveRoom(@RequestBody
                                   @Valid
                                   CourseRequestDTO course) {
        return service.createCourse(course);
    }
    @PutMapping("/update")
    public CourseRequestDTO updateRoom(@RequestBody
                                     @Valid
                                       UpdateCourseRequestDTO updateRoomRequestDTO){
        return service.updateRoom(updateRoomRequestDTO.id(),updateRoomRequestDTO.courseRequestDTO());
    }



}

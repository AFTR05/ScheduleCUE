package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.*;
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
    public List<CourseRequestDTO> getAllCourse() {
        return service.getAllCourses();
    }

    @GetMapping("/get-by-name/{name}")
    public CourseRequestDTO getCourseByName(@PathVariable
                                        String name) {
        return service.getOneCourse(name);
    }

    @GetMapping("/get-students/{course}")
    public List<StudentRequestDTO> getStudentsCourse(@PathVariable
                                                         String course){
        return service.getCourseStudents(course);
    }

    @GetMapping("/get-no-students/{course}")
    public List<StudentRequestDTO> getStudentsNoCourse(@PathVariable
                                                     String course){
        return service.getCourseNoStudents(course);
    }

    @PutMapping("/add-student")
    public CourseRequestDTO addStudent(@RequestBody
                                           @Valid
                                       AddStudentInterfaceDTO addStudentInterfaceDTO){
        return service.addStudent(addStudentInterfaceDTO);
    }

    @PostMapping("/create")
    public CourseRequestDTO saveCourse(@RequestBody
                                   @Valid
                                     CourseInterfaceDTO course) {
        return service.createCourse(course);
    }
    @PutMapping("/update")
    public CourseRequestDTO updateCourse(@RequestBody
                                     @Valid
                                       UpdateCourseRequestDTO updateRoomRequestDTO){
        return service.updateRoom(updateRoomRequestDTO.id(),updateRoomRequestDTO.courseRequestDTO());
    }



}

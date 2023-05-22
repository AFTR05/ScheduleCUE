package co.edu.cue.nucleo.nuclearProyect.infrastructure.controllers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.TeacherDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao;
    @GetMapping("/prove")
    public String prove(){
        return "prove teacher";
    }

    @RequestMapping(value = "api/teacher", method = RequestMethod.POST)
    public void registerTeacher(@RequestBody Teacher teacher){
        teacherDao.register(teacher);
    }
}

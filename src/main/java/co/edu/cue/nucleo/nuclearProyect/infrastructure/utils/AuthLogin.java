package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.LoginRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthLogin {
    public static String getAuth(LoginRequestDTO loginRequestDTO, List<Administrator> administrators, List<Student> students,
                                 List<Teacher> teachers){
        String auth = "";
        boolean isAdmin = administrators.stream()
                .anyMatch(administrator -> administrator.getId().equals(loginRequestDTO.id())
                        && administrator.getPassword().equals(loginRequestDTO.password()));
        boolean isStudent = students.stream()
                .anyMatch(student -> student.getId().equals(loginRequestDTO.id())
                        && student.getPassword().equals(loginRequestDTO.password()));
        boolean isTeacher = teachers.stream()
                .anyMatch(teacher -> teacher.getId().equals(loginRequestDTO.id())
                        && teacher.getPassword().equals(loginRequestDTO.password()));
        auth=isAdmin?"admin":isStudent?"student":isTeacher?"teacher":"";
        return auth;

    }

    public static Optional<Object> getLoginRequest(String value,LoginRequestDTO loginRequestDTO,List<Administrator> administrators,
                                         List<Student> students,List<Teacher> teachers){
        switch (value){
            case "admin":
                return Optional.of(administrators.stream().anyMatch(x -> x.getId().equals(loginRequestDTO.id()) &&
                        x.getPassword().equals(loginRequestDTO.password())));
            case "student":
                return Optional.of(students.stream().anyMatch(x -> x.getId().equals(loginRequestDTO.id()) &&
                        x.getPassword().equals(loginRequestDTO.password())));
            case "teacher":
                return Optional.of(teachers.stream().anyMatch(x -> x.getId().equals(loginRequestDTO.id()) &&
                        x.getPassword().equals(loginRequestDTO.password())));
            default:
                return Optional.empty();
        }
    }

    public static String authLogin(Optional<Student> s,Optional<Teacher> t,Optional<Administrator> a){
        if (s.isPresent()){
            return "student";
        }
        if (t.isPresent()){
            return "teacher";
        }
        if (a.isPresent()){
            return "administrator";
        }
        return "no";
    }

    public static String getTypeString(Object object) {
        if (object instanceof Administrator) {
            return "admin";
        } else if (object instanceof Student) {
            return "student";
        } else if (object instanceof Teacher) {
            return "teacher";
        } else {
            return "login";
        }
    }
}

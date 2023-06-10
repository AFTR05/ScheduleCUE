package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.ProgramSemester;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record StudentInterfaceDTO (@JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("active") Boolean active,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("course") List<Course> course,
        @JsonProperty("program") String program,
        @JsonProperty("modality")  String modality,
        @JsonProperty("semester")  String semester){
}

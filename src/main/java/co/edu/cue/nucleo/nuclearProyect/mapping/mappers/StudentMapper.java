package co.edu.cue.nucleo.nuclearProyect.mapping.mappers;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.StudentRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface StudentMapper {
    StudentRequestDTO mapToDTO(Student source);


    @Mapping(target = "id", ignore = true)
    Student mapToDTO(StudentRequestDTO source);
}

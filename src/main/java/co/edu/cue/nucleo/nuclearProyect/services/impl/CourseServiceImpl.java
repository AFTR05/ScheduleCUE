package co.edu.cue.nucleo.nuclearProyect.services.impl;


import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Subject;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Teacher;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.EquitmentRoom;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.StudentCourseDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.CourseDaoImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.DurationDaoImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.SearchEntity;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AddStudentInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.CourseRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.StudentRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.CourseMapper;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.StudentMapper;
import co.edu.cue.nucleo.nuclearProyect.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseDaoImpl objectDao;
    private final ObjectDao<Program> programDao;
    private final ObjectDao<Teacher> teacherDao;
    private final ObjectDao<Subject> subjectDao;
    private final ObjectDao<EquitmentRoom> equitmentDao;
    private final StudentCourseDao studentCourseDao;
    private final ObjectDao<Student> studentDao;
    private final DurationDaoImpl durationDao;
    private final CourseMapper mapper;
    private final StudentMapper mapperStudent;

    /**Este metodo traera toda la lista de courses de la base de datos
     * @return Lista de courses
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public List<CourseRequestDTO> getAllCourses() {
        return objectDao.list()
                .stream()
                .map(e -> mapper.mapToDTO(e))
                .toList();
    }

    /**
     * @param courseInterfaceDTO DTO de course con datos de interfaz
     * @return El objeto que se creo en la base de datos
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public CourseRequestDTO createCourse(CourseInterfaceDTO courseInterfaceDTO){
        String teacherId= courseInterfaceDTO.teacher().split("-")[0];
        CourseRequestDTO course=new CourseRequestDTO(SearchEntity.getDuration(courseInterfaceDTO.begin(),courseInterfaceDTO.end(),durationDao)
                ,teacherDao.byId(teacherId),subjectDao.byName(courseInterfaceDTO.subject())
                    ,programDao.byName(courseInterfaceDTO.program()),equitmentDao.byId(courseInterfaceDTO.equitment()));
        Course nativeCourse=mapper.mapToEntity(course);
        nativeCourse.setId(course.subject().getId()+"-"+course.program().getId()+"-"+course.teacher().getId());
        return mapper.mapToDTO(
                objectDao.save(
                        nativeCourse
                ));
    }

    /**
     * @param id Es el codigo del course a buscar
     * @return El objeto que se encontro con el id digitado en la base de datos
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public CourseRequestDTO getOneCourse(String id){
        return mapper.mapToDTO(
                objectDao.byName(id)
        );
    }

    /**
     * @param id Es el codigo del course a buscar
     * @param course DTO de course con datos de interfaz
     * @return El objeto que se actualiza segun las modificaciones en la base de datos
     * @author Andrés Felipe Toro Rendón
     */
    @Override
    public CourseRequestDTO updateRoom(String id, CourseRequestDTO course){
        Course courseUpdater=mapper.mapToEntity(course);
        courseUpdater.setId(id);
        return mapper.mapToDTO(
                objectDao.update(
                        id,courseUpdater
                ));
    }

    @Override
    public List<StudentRequestDTO> getCourseStudents(String course){
        String[] parts=course.split("-");
        String teacherName=parts[2];
        String subjectName=parts[0];
        String programName=parts[1];
        Course c=objectDao.byProps(teacherName,programName,subjectName).get();
        return c.getStudent()
                .stream()
                .map(e -> mapperStudent.mapToDTO((Student) e))
                .toList();
    }

    @Override
    public List<StudentRequestDTO> getCourseNoStudents(String course){
        String[] parts=course.split("-");
        String teacherName=parts[2];
        String subjectName=parts[0];
        String programName=parts[1];
        Course c=objectDao.byProps(teacherName,programName,subjectName).get();
        List<Student> students=studentDao.list();
        List<Student> courseStudents=c.getStudent();
        return students
                .stream().filter(x->courseStudents.stream().noneMatch(y->y.getId()==x.getId()))
                .map(e -> mapperStudent.mapToDTO((Student) e))
                .toList();
    }
    @Override
    public CourseRequestDTO addStudent(AddStudentInterfaceDTO addStudentInterfaceDTO){
        String studentId=addStudentInterfaceDTO.student().split("-")[0];
        String[] parts=addStudentInterfaceDTO.courseData().split("-");
        String teacherName=parts[2];
        String subjectName=parts[0];
        String programName=parts[1];
        Course c=objectDao.byProps(teacherName,programName,subjectName).get();
        Student student=studentDao.byId(studentId);
        c.getStudent().add(student);
        studentCourseDao.createWithNoID(student.getId(),c.getId());
        return mapper.mapToDTO(c
                );
    }




}

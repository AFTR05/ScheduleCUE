package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.*;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation.DayValidation;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation.MaximumValidator;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation.TimeValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseHourGenerator {
    public static Optional<HourInterval> generateHour(Course course, Integer countClass) { // esto hace que confirme
        for (HourInterval interval:course.getTeacher().getHour_interval()) {// la hora
            if (!DayValidation.validateCourseOnDay(course, interval.getDay())) {
                continue;
            }
            while (true){
                Optional<HourInterval> hourInterval=TimeOperator.additionInterval(interval,countClass);
                if (hourInterval.isEmpty()|| TimeValidator.validateLunch(hourInterval.get())){
                    break;
                }
                List<Student> studentRegret = validateTotalhours(course,hourInterval.get()); // codigo de validacion de dia total de
                List<Student> rh= searchSpace(course.getStudent(), interval).get(); // horas dia
                if (studentRegret.isEmpty() && rh.isEmpty()){
                    Optional<List<Student>> campusStudent= searchCampus(course.getStudent(),interval);
                    if (campusStudent.get().isEmpty()){
                        return hourInterval;
                    }else {
                        Optional<HourInterval> fixHour=TimeOperator.plusBoth(hourInterval.get(),interval,1);
                        if (fixHour.isEmpty() || TimeValidator.validateLunch(fixHour.get())) {
                            break;
                        } else {
                            return fixHour;
                        }
                    }
                }
                Optional<HourInterval> increment=TimeOperator.incrementOrigin(interval,countClass);
                if (increment.isEmpty()){
                    break;
                }
            }
        }return Optional.empty();
    }

    public static List<Student> validateTotalhours(Course course,HourInterval hourInterval){
        return course.getStudent().stream().
                filter(x -> MaximumValidator.validateMaximumDay(DisponibilitySearcher
                        .dayDisponibility(x, hourInterval.getDay()).get()))
                .toList();
    }
    public static Optional<List<Student>> searchSpace(List<Student> students, HourInterval hourInterval) {
        return Optional.of(students.stream().filter(x -> DisponibilitySearcher
                .studentDisponibility(hourInterval, x).get().isEmpty()).collect(Collectors.toList()));
    } // busca si hay disponibilidad en un determinado espacio

    public static Optional<List<Student>> searchCampus(List<Student> students, HourInterval hourInterval){
        return Optional.of(students.stream().filter(x->DisponibilitySearcher.studentBeforeDisponibility(hourInterval,x)
                .get().stream().map(y->y.getRoom().getCampus()).distinct().count()!=1).collect(Collectors.toList()));
    } // busca si todos los estudiantes antes de ese espacio estan en la misma sede

    public static void generateWithAll(Course course,List<Room> rooms){  //fix
        List<Integer> countClasses=NumberToArray.transformNumber(course.getSubject().getCountSemanalHours());
        makeAll(course,rooms,countClasses);
    }

    public static Optional<Course> makeAll(Course course, List<Room> rooms,List<Integer> countClasses){ //fix
        for (Integer c:countClasses) {
            Optional<RoomHour> optionalRoomHour=generateIndividualClass(course, rooms, c);
            optionalRoomHour.ifPresent(roomHour -> course.getHourRoom().add(roomHour));
        }
        return Optional.of(course);
    }

    public static Optional<RoomHour> generateIndividualClass(Course course,List<Room> rooms,Integer countClass){  //fix
        Optional<HourInterval> hourInterval=generateHour(course,countClass);
        if (hourInterval.isPresent()){
            return generateWithRoom(hourInterval.get(),rooms,course);
        }
        return Optional.empty();
    }
    public static Optional<RoomHour> generateWithRoom(HourInterval hourInterval, List<Room> rooms, Course course) {  //fix
        if (RoomPrioritizer.getRoomNecessary(rooms,course).isPresent()){
            List<Room> roomList=RoomPrioritizer.getRoomNecessary(rooms,course).get();
            return Optional.of(new RoomHour(hourInterval,roomList.get(0),course));
        }
        return Optional.empty();
    }



    //Lista de validaciones

    /* - Validar Que no este el tiempo entre lsa 13 y 14  '
       - Validar que el curso no se mas de una vez al dia '
       - Validar que la anterior clase a la actual no sea en una sede distinta, si es asi ampliar el inicio una hora el inicio y final '
       - Validar que no se vean mas de 9 horas al dia en cursos '
       - Validar la cantidad de horas semanales que si sean generadas
       -

       Lista validaciones por orden
       - Validar tipos de materia
       - Validar segun cantidad de disponibilidad del profe */

    // revisar que el curso no se este viendo en el mismo dia
    // apartir de ahi
    // validar que todos estudiantes que vean clase en el inicio de la clase sean de la misma sede, si es asi entonces usar esa sede que
    // ven
    // sino entonces dar una hora para que inicie la clase, si el profesor tiene el espacio disponible de aplazamiento melo
    // tener en cuenta la hora de almuerzo
    // sino escoger otro horario
    // validar el orden de generacion
    // 

}

package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseHourGenerator {
    public static Optional<HourInterval> generateHour(Course course, Integer countClass) { // esto hace que confirme
        for (HourInterval interval:course.getTeacher().getHour_interval()) {                                                             // la hora
            while (true){
                Optional<HourInterval> hourInterval=TimeOperator.additionInterval(interval,countClass);
                if (hourInterval.isEmpty()){
                    break;
                }
                List<Student> studentRegret = course.getStudent().stream().
                        filter(x -> DisponibilitySearcher.dayDisponibility(x, hourInterval.get().getDay()).get() == 9) // codigo de validacion de
                        .collect(Collectors.toList());
                List<RoomHour> rh= (List<RoomHour>) searchSpace(course.getStudent(), interval).get();
                if (studentRegret.isEmpty() && rh.isEmpty()){
                   return Optional.of(hourInterval.get());
                }
                TimeOperator.incrementOrigin(interval,2);
                if (TimeOperator.incrementOrigin(interval,countClass).isEmpty()){
                    break;
                }
            }
        }
        return Optional.empty();
    }
    public static Optional<RoomHour> searchSpace(List<Student> students, HourInterval hourInterval) {
        return Optional.of((RoomHour) students.stream().filter(x -> DisponibilitySearcher.studentDisponibility(hourInterval, x).isEmpty()).collect(Collectors.toList()));
    }

    public static Optional<Course> generateWithAll(Course course,List<Room> rooms){
        List<Integer> countClasses=NumberToArray.transformNumber(course.getSubject().getCountSemanalHours());
        return makeAll(course,rooms,countClasses);
    }

    public static Optional<Course> makeAll(Course course, List<Room> rooms,List<Integer> countClasses){
        for (Integer c:countClasses) {
            Optional<RoomHour> optionalRoomHour=generateIndividualClass(course, rooms, c);
            optionalRoomHour.ifPresent(roomHour -> course.getHourRoom().add(roomHour));
        }
        return Optional.of(course);
    }

    public static Optional<RoomHour> generateIndividualClass(Course course,List<Room> rooms,Integer countClass){
        Optional<HourInterval> hourInterval=generateHour(course,countClass);
        if (hourInterval.isPresent()){
            return generateWithRoom(hourInterval.get(),rooms,course);
        }
        return Optional.empty();
    }
    public static Optional<RoomHour> generateWithRoom(HourInterval hourInterval, List<Room> rooms, Course course) {
        if (RoomPrioritizer.getRoomNecessary(rooms,course).isPresent()){
            List<Room> roomList=RoomPrioritizer.getRoomNecessary(rooms,course).get();
            return Optional.of(new RoomHour(hourInterval,roomList.get(0),course));
        }
        return Optional.empty();
    }
}

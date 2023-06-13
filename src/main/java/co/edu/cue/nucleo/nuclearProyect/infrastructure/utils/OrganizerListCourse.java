package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrganizerListCourse {

    public static List<Course> organizeWithAll(List<Course> courses, List<Room> rooms){
        List<Course> courseListWithNoSchedule=courseListWithNoSchedule(courses);
        List<Course> coursesWithNoSchedule=organizeBySubject(courseListWithNoSchedule);
        coursesWithNoSchedule.forEach(x->CourseHourGenerator.generateWithAll(x,rooms));

        List<Course> coursesWithLowDisponibility=sortByDisponibility(courseListWithNoSchedule(courses));
        coursesWithLowDisponibility.forEach(x->CourseHourGenerator.generateWithAll(x,rooms));
        return courses;
    }
    public static List<Course> courseListWithNoSchedule(List<Course> courses){
        return courses.stream().filter(x->x.getHourRoom().isEmpty()).collect(Collectors.toList());
    }

    public static List<Course> organizeBySubject(List<Course> courses){
        return courses.stream().filter(x->x.getSubject().getTypeSubject().getId().equals("CBU"))
                .collect(Collectors.toList());
    }

    public static List<Course> sortByDisponibility(List<Course> courses){
        return courses.stream().sorted(Comparator.comparingInt(DisponibilitySearcher::sumTeacherDisponibility)).collect(Collectors.toList());
    }
}

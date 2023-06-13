package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.HourRoomDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HourRoomDaoImpl implements HourRoomDao {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void createWithAtt(HourInterval hourInterval, Room room, Course course){
            Query query=entityManager.createNativeQuery("INSERT INTO `hour_room` (`hour_interval_id`, `room_" +
                    "id`, `course_id`) VALUES (?1, ?2, ?3)");
        query.setParameter(1, hourInterval.getId());
        query.setParameter(2, room.getId());
        query.setParameter(3,course.getId());
        query.executeUpdate();
    }
}

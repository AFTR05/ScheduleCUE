package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RoomDaoImpl implements ObjectDao<Room> {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Room> list() {
        String query = "FROM Room";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Room byId(String id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public Room save(Room o) {
        return entityManager.merge(o);
    }

    @Override
    public void delete(String id) {
        Room room= entityManager.find(Room.class, id);
        entityManager.remove(room);
    }

    @Override
    public Room update(String id, Room o) {
        Room room=entityManager.find(Room.class,id);
        room.setName(o.getName());
        room.setEquitmentRoom(o.getEquitmentRoom());
        room.setCapacity(o.getCapacity());
        room.setId(id);
        room.setActive(o.getActive());
        save(room);
        return room;
    }

    @Override
    public Room byName(String name) {
        Query query=entityManager.createQuery("select r from Room r where r.name=?1", Room.class);
        query.setParameter(1, name);
        query.setMaxResults(1);
        return (Room) query.getSingleResult();
    }
}

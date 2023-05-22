package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao;

import java.util.HashSet;
import java.util.List;

public interface ObjectDao<T> {
    List<T> list();
    T byId(String id);
    T save(T t);
    void delete(String id);
    T update(String id,T t);
    T byName(String name);
}

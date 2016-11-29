package bsuir.scouting.service;


import java.util.List;

public interface BaseService<T, Long> {
    void delete(Long id);

    List<T> findAll();

    T findOne(Long id);

    T save(T entity);

}


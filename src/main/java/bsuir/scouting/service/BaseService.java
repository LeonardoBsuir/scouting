package bsuir.scouting.service;


import java.util.List;

public interface BaseService<T, K> {
    void delete(T entity);

    List<T> findAll();

    T findOne(K id);

    T save(T entity);
}


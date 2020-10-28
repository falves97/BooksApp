package dao;

import java.util.List;

public interface EntitieDAO<T> {
    void insert(T t);
    void update(T t);
    void deletById(Integer id);
    T findById(Integer id);
    List<T> findAll();
}

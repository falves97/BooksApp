package dao;

import java.sql.Connection;
import java.util.List;

public interface EntitieDAO<T> {
    void insert(T t);
    void update(T t);
    void deletById(Long id);
    T findById(Long id);
    List<T> findAll();
    Connection getConnection();
}

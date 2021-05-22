package ua.goit.jdbc.dao;

public interface Repository<T>{

    T findById(Integer id);
    T create(T entity);
    void update(T entity);
    void delete(Integer id);

    Integer getLastId();
}

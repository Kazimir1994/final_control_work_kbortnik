package ru.kazimir.bornik.final_control_work_kbortnik.repository;

import java.util.List;

public interface GenericRepository<I, T> {

    void persist(T entity);

    void merge(T entity);

    void remove(T entity);

    T findById(I id);

    List<T> findAll(Long offset, Long limit);

    List<T> findAll();

    Long getCountOfEntities();
}

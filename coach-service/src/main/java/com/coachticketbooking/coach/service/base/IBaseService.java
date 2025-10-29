package com.coachticketbooking.coach.service.base;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    List<T> saveAll(List<T> entities);
    void deleteById(ID id);
    void delete(T entity);
    boolean existsById(ID id);
}

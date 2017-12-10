package com.amdsystems.test.data.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable, ID> {

    T findOne(ID id);

    void create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(ID entityId);

    void addAll(List<T> list);
}

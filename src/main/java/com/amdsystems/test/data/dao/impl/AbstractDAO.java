package com.amdsystems.test.data.dao.impl;


import com.amdsystems.test.data.dao.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDAO<T extends Serializable, ID> implements DAO<T, ID> {

    protected Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    protected AbstractDAO(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Override
    public T findOne(ID id) {
        return entityManager.find(clazz, id);
    }

    @Override
    @Transactional
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    @Transactional
    public void deleteById(ID entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
    @Override
    @Transactional
    public void addAll(List<T> list) {
        for (T entity: list)
            create(entity);
    }
}

package com.uniyaz.sakila.core.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseService<T extends BaseEntity, D extends BaseDao> {

    @Autowired

    D dao;

    public List<T> findAll() {
        return dao.findAll();
    }

    public T save(T entity) {
        return (T) dao.save(entity);
    }
}

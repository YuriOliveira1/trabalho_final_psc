package com.yurioliveira.doacoes.model.dao;

import java.util.List;

public interface DAO<T> {
    public void insert(T obj);
    public void update(T obj);
    public void deleteById(Integer id);
    public T findById(Integer id);
    public List<T> findAll();
}

package com.internet.shop.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, R> {
    T create(T element);

    Optional<T> get(R id);

    List<T> getAll();

    T update(T element);

    boolean delete(R id);

}

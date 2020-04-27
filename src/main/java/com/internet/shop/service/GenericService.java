package com.internet.shop.service;

import java.util.List;

public interface GenericService<T, R> {
    T create(T element);

    T get(R id);

    List<T> getAll();

    T update(T element);

    boolean delete(R id);
}

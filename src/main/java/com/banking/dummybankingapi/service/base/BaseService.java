package com.banking.dummybankingapi.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<E> {

    void save(E e);

    void delete(Long id);

    void update(E e);

    Optional<E> findById(Long id);

    List<E> findAll();
}

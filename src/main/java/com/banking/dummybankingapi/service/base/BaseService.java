package com.banking.dummybankingapi.service.base;

import com.banking.dummybankingapi.model.base.BaseEntity;
import com.banking.dummybankingapi.service.dto.base.BaseRequestDto;

import java.io.Serializable;
import java.util.List;

public interface BaseService<ID extends Serializable, E extends BaseEntity<ID>> {

    E save(E entity);

    void delete(Long id);

    E update(E entity);

    E findById(Long id);

    List<E> findAll();
}

package com.banking.dummybankingapi.service.base;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E, R extends JpaRepository<E, Long>> implements BaseService<E> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void save(E e) {
        repository.save(e);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this
                .findById(id)
                .ifPresent(repository::delete);
    }

    @Transactional
    @Override
    public void update(E e) {
        repository.save(e);

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
}

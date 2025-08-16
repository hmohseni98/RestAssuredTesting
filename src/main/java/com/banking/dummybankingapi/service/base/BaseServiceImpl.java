package com.banking.dummybankingapi.service.base;


import com.banking.dummybankingapi.model.base.BaseEntity;
import com.banking.dummybankingapi.service.dto.base.BaseRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<ID extends Serializable, E extends BaseEntity<ID>, R extends JpaRepository<E, ID>>
        implements BaseService<ID, E> {

    private final ModelMapper modelMapper;
    private final Class<E> entityClass;

    private final Class<ID> idClass;
    protected final R repository;

    protected BaseServiceImpl(ModelMapper modelMapper, Class<E> entityClass, Class<ID> idClass, R repository) {
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
        this.idClass = idClass;
        this.repository = repository;
    }


    @Transactional
    @Override
    public void save(E entity) {
        repository.save(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        E entity = this.findById(id);

        if (entity != null) {
            repository.delete(entity);
        }
    }

    @Transactional
    @Override
    public void update(E entity) {
        repository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public E findById(Long id) {
        return repository.findById(idClass.cast(id)).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
}

package org.homeapart.repository.impl;

import org.homeapart.domain.Additionally;
import org.homeapart.repository.AdditionallyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AdditionallyRepositoryImpl implements AdditionallyRepository {
    @Override
    public List<Additionally> findByApartId(long id) {
        return null;
    }

    @Override
    public Additionally save(Additionally object) {
        return null;
    }

    @Override
    public List<Additionally> findAll() {
        return null;
    }

    @Override
    public Additionally findById(Long key) {
        return null;
    }

    @Override
    public Additionally update(Additionally object) {
        return null;
    }

    @Override
    public Long delete(Additionally object) {
        return null;
    }
}

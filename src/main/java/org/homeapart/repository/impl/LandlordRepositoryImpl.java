package org.homeapart.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.homeapart.domain.Landlord;
import org.homeapart.repository.LandlordRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Log4j2
public class LandlordRepositoryImpl implements LandlordRepository {

    @Override
    public Optional<Landlord> findByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public Landlord save(Landlord object) {
        return null;
    }

    @Override
    public List<Landlord> findAll() {
        return null;
    }

    @Override
    public Landlord findById(Long key) {
        return null;
    }

    @Override
    public Landlord update(Landlord object) {
        return null;
    }

    @Override
    public Long delete(Landlord object) {
        return null;
    }
}

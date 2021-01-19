package org.homeapart.service.Impl;

import org.homeapart.domain.Apart;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.domain.enums.ApartamentType;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import org.homeapart.repository.ApartRepository;
import org.homeapart.service.ApartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ApartServiceImpl implements ApartService {

    private final ApartRepository apartRepository;

    public ApartServiceImpl(ApartRepository apartRepository) {
        this.apartRepository = apartRepository;
    }

    @Override
    public List<Apart> findAll() {
        return apartRepository.findAll();
    }

    @Override
    public Apart save(Apart apart) {
        return apartRepository.save(apart);
    }

    @Override
    public Apart update(Apart apart) {
        return apartRepository.update(apart);
    }

    @Override
    public Optional<Apart> findById(Long apartId) {
        return apartRepository.findById(apartId);
    }

    @Override
    public List <Apart> findByType(ApartamentType type) {
        return apartRepository.findByType(type);
    }

    @Override
    public List<Apart> findByStatus(ApartamentStatus status) {
        return apartRepository.findByStatus(status);
    }

    @Override
    public Long delete(Apart apart) {
        return apartRepository.delete(apart);
    }

    @Override
    public List<Apart> findApartByLandlordId(Long landlordId) {
        return apartRepository.findByLandlordId(landlordId);
    }

    @Override
    public List<Apart> findByParam(Country country, City city, Integer questNumber, ApartamentType type, Double costPerDay) {
        return apartRepository.findByParam(country,
              city,
            questNumber,
             type,
             costPerDay);
    }
}

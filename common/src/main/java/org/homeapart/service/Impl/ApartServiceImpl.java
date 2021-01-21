package org.homeapart.service.Impl;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ApartServiceImpl implements ApartService {

    private final ApartRepository apartRepository;


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
        return apartRepository.save(apart);
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
    public Long delete(Long apartId) {
        return apartRepository.deleteApartById(apartId);
    }

    @Override
    public List<Apart> findApartByLandlordId(Long landlordId) {
        return apartRepository.findByLandlordId(landlordId);
    }

    @Override
    public List<Apart> findByParam(Country country, City city, Integer questNumber, ApartamentType type, Double costPerDay) {
        return apartRepository.findByAddress_CountryAndAddress_CityAndGuestNumberAndTypeAndCostPerDay(country,
              city,
            questNumber,
             type,
             costPerDay);
    }
}

package org.homeapart.service;

import org.homeapart.domain.Apart;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.domain.enums.ApartamentType;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;
import java.util.Optional;

public interface ApartService {


    List<Apart> findAll();

    Apart save(Apart apart);

    Apart update(Apart apart);


    Optional<Apart> findById(Long apartId);


    List <Apart> findByType(ApartamentType type);


    List <Apart> findByStatus(ApartamentStatus status);

    Long delete (Long apartId);

    List<Apart> findApartByLandlordId(Long landlordId);


    List<Apart> findByParam(Country country,
                                   City city,
                                   Integer questNumber,
                                   ApartamentType type,
                                   Double costPerDay);
}

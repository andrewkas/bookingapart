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

    @Cacheable("apart")
    List<Apart> findAll();

    Apart save(Apart apart);

    Apart update(Apart apart);

    @Cacheable("apart")
     Optional<Apart> findById(Long apartId);

    @Cacheable("apart")
    List <Apart> findByType(ApartamentType type);

    @Cacheable("apart")
    List <Apart> findByStatus(ApartamentStatus status);

    Long delete (Apart apart);

    List<Apart> findApartByLandlordId(Long landlordId);

    @Cacheable("apart")
    List<Apart> findByParam(Country country,
                                   City city,
                                   Integer questNumber,
                                   ApartamentType type,
                                   Double costPerDay);
}

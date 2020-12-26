package org.homeapart.service;

import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.domain.enums.ApartamentType;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;

import java.util.List;

public interface ApartService {
    List<Apart> findAll();

    Apart save(Apart apart);

    Apart update(Apart apart);

    Apart findById(Long apartId);

    List <Apart> findByType(ApartamentType type);

    List <Apart> findByStatus(ApartamentStatus status);

    Long delete (Apart apart);

    List<Apart> findApartByLandlordId(Long landlordId);

    List<Apart> findByParam(Country country,
                                   City city,
                                   Integer questNumber,
                                   ApartamentType type,
                                   Double costPerDay);
}

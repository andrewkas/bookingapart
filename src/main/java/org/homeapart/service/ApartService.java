package org.homeapart.service;

import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;

import java.util.List;

public interface ApartService {
    List<Apart> findAll();

    Apart save(Apart apart);

    Apart update(Apart apart);

    Apart findById(Long apartId);

    List <Apart> findByType(String type);

    List <Apart> findByStatus(ApartamentStatus status);

    Long delete (Apart apart);

    List<Apart> findApartByLandlord (Landlord landlord);
}

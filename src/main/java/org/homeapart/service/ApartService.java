package org.homeapart.service;

import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;

import java.util.List;

public interface ApartService {
    List<Apart> findAll();

    Apart save(Apart apart);

    Apart update(Apart apart);

    Apart findById(Long apartId);

    List <Apart> findByType(String type);

    List <Apart> findByStatus(String status);

    Long delete (Apart apart);

    List<Apart> findApartByLandlord (Landlord landlord);
}

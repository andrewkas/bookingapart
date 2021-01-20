package org.homeapart.repository;

import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.domain.enums.ApartamentType;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface ApartRepository extends JpaRepository< Apart, Long> {

    //List<Apart> search(String query);

    List<Apart> findByAddress_CountryAndAddress_City(String country,String city);

    List<Apart> findByStatus(ApartamentStatus status);

    List <Apart> findByType(ApartamentType type);

    List <Apart> findByLandlordId(Long landlordId);

    List<Apart> findByAddress_CountryAndAddress_CityAndGuestNumberAnAndTypeAndCostPerDay(Country country,
                                                                                                City city,
                                                                                                Integer questNumber,
                                                                                                ApartamentType type,
                                                                                                Double costPerDay);


    Apart update(Apart apart);

    Long deleteApartById(Long apartId);
}

package org.homeapart.repository;

import org.homeapart.domain.Apart;
import org.homeapart.domain.Booking;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.domain.enums.ApartamentType;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ApartRepository extends JpaRepository< Apart, Long> {

    //List<Apart> search(String query);

    List<Apart> findByAddress_CountryAndAddress_City(String country,String city);

    List<Apart> findByStatus(ApartamentStatus status);

    List <Apart> findByType(ApartamentType type);

    List <Apart> findByLandlordId(Long landlordId);

    @Query(value="select a from Apart a where a.address.country=:country and a.address.city=:city " +
              "and a.guestNumber>:questNumber and a.type=:type and a.costPerDay<:costPerDay ")
    List<Apart> findByAddress_CountryAndAddress_CityAndGuestNumberAndTypeAndCostPerDay(Country country
                                                                                       ,City city
                                                                                       ,Integer questNumber
                                                                                       ,ApartamentType type
                                                                                       ,Double costPerDay
                                                                                     //  ,Date dateFrom
                                                                                     //  ,Date dateTo
    );



    void deleteApartById(Long apartId);


}

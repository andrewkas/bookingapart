package org.homeapart.repository;

import org.homeapart.domain.Address;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCity(City city);

    List<Address> findByCountry(Country country);

    List<Address> findByCountryAndCity(Country country,City city);

}

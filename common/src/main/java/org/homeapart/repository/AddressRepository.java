package org.homeapart.repository;

import org.homeapart.domain.Address;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;

import java.util.List;


public interface AddressRepository extends CrudRepository<Long,Address> {

    List<Address> findByCity(City city);

    List<Address> findByCountry(Country country);

    List<Address> findByCountryAndCity(Country country,City city);

}

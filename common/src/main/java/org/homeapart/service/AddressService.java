package org.homeapart.service;

import org.homeapart.domain.Address;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import java.util.List;

public interface AddressService {
    List<Address> findAll();

    Address save(Address address);

    Address findById(Long id);

    List<Address> findByCity(City city);

    List<Address> findByCountry(Country country);

    List<Address> findByCountryAndCity(Country country,City city);





}

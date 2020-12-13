package org.homeapart.service;

import org.homeapart.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();

    Address save(Address address);

    Address findById(Long id);

    Address findByCity(String city);

    Address findByCountry(String country);



}

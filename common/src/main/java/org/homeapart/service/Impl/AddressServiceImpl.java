package org.homeapart.service.Impl;

import org.homeapart.domain.Address;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import org.homeapart.repository.AddressRepository;
import org.homeapart.service.AddressService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> optional= addressRepository.findById(id);
        return optional.orElseGet(optional::orElseThrow);
    }


    @Override
    public List<Address> findByCity(City city) {
        return addressRepository.findByCity(city);
    }

    @Override
    public List<Address> findByCountry(Country country) {
        return addressRepository.findByCountry(country);
    }

    @Override
    public List<Address> findByCountryAndCity(Country country, City city) {
        return addressRepository.findByCountryAndCity(country,city);
    }
}


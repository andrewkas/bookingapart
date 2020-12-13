package org.homeapart.service.Impl;

import org.homeapart.domain.Address;
import org.homeapart.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressService addressService;

    public AddressServiceImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @Override
    public Address save(Address address) {
        return addressService.save(address);
    }

    @Override
    public Address findById(Long id) {
        return addressService.findById(id);
    }

    @Override
    public Address findByCity(String city) {
        return addressService.findByCity(city);
    }

    @Override
    public Address findByCountry(String country) {
        return addressService.findByCountry(country);
    }
}

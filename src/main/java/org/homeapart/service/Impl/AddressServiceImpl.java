package org.homeapart.service.Impl;

import org.homeapart.domain.Address;
import org.homeapart.repository.AddressRepository;
import org.homeapart.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return addressRepository.findById(id);
    }

    @Override
    public Address findByCity(String city) {
        return addressRepository.findByCity(city);
    }

    @Override
    public Address findByCountry(String country) {
        return addressRepository.findByCountry(country);
    }
}

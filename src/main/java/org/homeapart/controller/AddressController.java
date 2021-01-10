package org.homeapart.controller;

import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.AddressCreateRequest;
import org.homeapart.domain.Address;
import org.homeapart.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<Address> all = addressService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address savingAddress(@RequestBody AddressCreateRequest addressCreateRequest) {
        //converters
        Address address = new Address();
        address.setCountry(addressCreateRequest.getCountry());
        address.setCity(addressCreateRequest.getCity());
        address.setLocation(addressCreateRequest.getLocation());
        return addressService.save(address);

    }

}

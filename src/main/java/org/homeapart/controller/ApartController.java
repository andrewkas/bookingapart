package org.homeapart.controller;

import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.ApartCreateRequest;
import org.homeapart.controller.request.LandlordCreateRequest;
import org.homeapart.controller.request.UserDeleteRequest;
import org.homeapart.controller.response.ErrorMassages;
import org.homeapart.domain.Additionally;
import org.homeapart.domain.Address;
import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.*;
import org.homeapart.service.AdditionallyService;
import org.homeapart.service.AddressService;
import org.homeapart.service.ApartService;
import org.homeapart.service.LandlordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/apart")
@RequiredArgsConstructor
public class ApartController {

    private final ApartService apartService;

    private final AddressService addressService;

    private final LandlordService landlordService;


    @GetMapping("/all")
    public ResponseEntity<Object> findAllApart() {
        List<Apart> all = apartService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Apart findById(@RequestParam (value="id") Long id) {
        return apartService.findById(id);
    }

    @GetMapping("/{apartamentStatus}")
    @ResponseStatus(HttpStatus.OK)
    public List<Apart> findByStatus(@PathVariable ApartamentStatus apartamentStatus){
        return apartService.findByStatus(apartamentStatus);
    }
    @GetMapping("/type")
    @ResponseStatus(HttpStatus.OK)
    public List<Apart> findByType(@RequestParam (value="type") ApartamentType type){
        return apartService.findByType(type);
    }

    @GetMapping("/address")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> findByAddress(@RequestParam Country country, @RequestParam City city){
        return addressService.findByCountryAndCity(country,city);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<Apart> findForUser(@RequestParam Country country,
                                     @RequestParam City city,
                                     @RequestParam Integer questNumber,
                                     @RequestParam ApartamentType type,
                                     @RequestParam Double costPerDay){
        return apartService.findByParam(country,city,questNumber,type,costPerDay);
    }


    @PostMapping ("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Apart savingApart(@RequestBody ApartCreateRequest apartCreateRequest ) {

        Apart apart=new Apart();
        apart.setAddress(new Address(apartCreateRequest.getAddress().getCountry()
                ,apartCreateRequest.getAddress().getCity()
                ,apartCreateRequest.getAddress().getLocation()));
        apart.setApartName(apartCreateRequest.getApartName());
        apart.setArea(apartCreateRequest.getArea());
        apart.setCostPerDay(apartCreateRequest.getCostPerDay());
        apart.setLandlord(landlordService.findById(apartCreateRequest.getLandlordId()));
        apart.setAdditionally(apartCreateRequest.getAdditionallySet());
        apart.setCreated(new Timestamp((System.currentTimeMillis())));
        apart.setChanged(new Timestamp(System.currentTimeMillis()));
        apart.setType(apartCreateRequest.getType());
        apart.setGuestNumber(apartCreateRequest.getGuestNumber());
        apart.setStatus(apartCreateRequest.getStatus());

        return apartService.save(apart);

    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Apart updateApart(@PathVariable Long id,

                                   @RequestBody ApartCreateRequest apartCreateRequest) {
        Apart apart=apartService.findById(id);
        apart.setAddress(new Address(apartCreateRequest.getAddress().getCountry()
                ,apartCreateRequest.getAddress().getCity()
                ,apartCreateRequest.getAddress().getLocation()));
        apart.setApartName(apartCreateRequest.getApartName());
        apart.setArea(apartCreateRequest.getArea());
        apart.setCostPerDay(apartCreateRequest.getCostPerDay());
        apart.setLandlord(landlordService.findById(apartCreateRequest.getLandlordId()));
        apart.setAdditionally(apartCreateRequest.getAdditionallySet());
        apart.setChanged(new Timestamp(System.currentTimeMillis()));
        apart.setType(apartCreateRequest.getType());
        apart.setGuestNumber(apartCreateRequest.getGuestNumber());
        apart.setStatus(apartCreateRequest.getStatus());

        return apartService.save(apart);

    }


    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long deleteApart(@PathVariable Long id) {
        if(apartService.findById(id)==null) throw new IllegalArgumentException("apartments do not exist");
        Apart apart = apartService.findById(id);
        return apartService.delete(apart);
    }
}



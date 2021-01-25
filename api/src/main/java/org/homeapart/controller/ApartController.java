package org.homeapart.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.ApartChangeRequest;
import org.homeapart.controller.request.ApartCreateRequest;
import org.homeapart.domain.Address;
import org.homeapart.domain.Apart;
import org.homeapart.domain.enums.*;
import org.homeapart.service.AddressService;
import org.homeapart.service.ApartService;
import org.homeapart.service.LandlordService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/apart")
@Api( tags = "APARTAMENTS")
@RequiredArgsConstructor
public class ApartController {

    private final ApartService apartService;

    private final AddressService addressService;

 //   private final LandlordService landlordService;

    private final ConversionService conversionService;


    @GetMapping("/all")
    public ResponseEntity<Object> findAllApart() {
        List<Apart> all = apartService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Apart findById(@RequestParam (value="id") Long id) {
        return apartService.findById(id).orElseThrow(()->new EntityNotFoundException("Apart with id "+id+" not found!"));
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
        List<Address> addresses=addressService.findByCountryAndCity(country,city);
        if (addresses.isEmpty()){
            throw new EntityNotFoundException("Apartments not found! Check or change address!");}

        else
        return addresses;
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
        Apart apart= conversionService.convert(apartCreateRequest,Apart.class);
        return apartService.save(apart);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Apart updateApart(@RequestBody ApartChangeRequest apartChangeRequest) {
        if (apartService.findById(apartChangeRequest.getId()).isPresent()) {
            Apart apart = conversionService.convert(apartChangeRequest, Apart.class);
            return apartService.update(apart);
        } else throw new EntityNotFoundException("Apart with id " + apartChangeRequest.getId() + " not found");
    }

    @Transactional
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteApart(@PathVariable Long id) {
        Apart apart = apartService.findById(id).orElseThrow(()->new EntityNotFoundException("Apart with id "+id+" not found" ));
         apartService.delete(id);
        return new ResponseEntity("Deleted",HttpStatus.OK);
    }
}



package org.homeapart.controller;

import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.ApartCreateRequest;
import org.homeapart.controller.request.LandlordCreateRequest;
import org.homeapart.controller.request.UserDeleteRequest;
import org.homeapart.domain.Address;
import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.service.AddressService;
import org.homeapart.service.ApartService;
import org.homeapart.service.LandlordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/apart")
@RequiredArgsConstructor
public class ApartController {

    private final ApartService apartService;

    private final AddressService addressService;

    private final LandlordService landlordService;

  //  private AdditionallyService additionallyService;

    @GetMapping
    public ResponseEntity<Object> findAllApart() {
        List<Apart> all = apartService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Landlord findLandlordById(@PathVariable Long id) {
        return landlordService.findById(id);
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
        //apart.setAdditionally(additionallyService.findAll(apartCreateRequest.getAdditionallySet().getAdditionally));
        apart.setCreated(new Timestamp((System.currentTimeMillis())));
        apart.setChanged(new Timestamp(System.currentTimeMillis()));
        apart.setType(apartCreateRequest.getType());
        apart.setGuestNumber(apartCreateRequest.getGuestNumber());
        apart.setStatus(ApartamentStatus.AVAILABLE);

        return apartService.save(apart);

    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Apart updateLandlord(@PathVariable Long id,

                                   @RequestBody ApartCreateRequest apartCreateRequest) {
        Apart apart=apartService.findById(id);
        apart.setAddress(new Address(apartCreateRequest.getAddress().getCountry()
                ,apartCreateRequest.getAddress().getCity()
                ,apartCreateRequest.getAddress().getLocation()));
        apart.setApartName(apartCreateRequest.getApartName());
        apart.setArea(apartCreateRequest.getArea());
        apart.setCostPerDay(apartCreateRequest.getCostPerDay());
        apart.setLandlord(landlordService.findById(apartCreateRequest.getLandlordId()));
        //apart.setAdditionally(additionallyService.findAll(apartCreateRequest.getAdditionallySet().getAdditionally));
        apart.setChanged(new Timestamp(System.currentTimeMillis()));
        apart.setType(apartCreateRequest.getType());
        apart.setGuestNumber(apartCreateRequest.getGuestNumber());
        apart.setStatus(ApartamentStatus.AVAILABLE);

        return apartService.save(apart);

    }


    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long deleteApart(@PathVariable Long id) {
        Apart apart = apartService.findById(id);

        return apartService.delete(apart);
    }
}



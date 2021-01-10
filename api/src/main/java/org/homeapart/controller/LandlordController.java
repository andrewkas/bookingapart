package org.homeapart.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.*;
import org.homeapart.domain.Landlord;
import org.homeapart.service.LandlordService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;

import java.util.List;
@RestController
@RequestMapping("/landlord")
@Api( tags = "LANDLORD")
@RequiredArgsConstructor
public class LandlordController {

        private final LandlordService landlordService;

        private final ConversionService conversionService;


        @GetMapping
        public ResponseEntity<Object> findAllLandlord() {
            List<Landlord> all = landlordService.findAll();
            return new ResponseEntity<>(all, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Landlord findLandlordById(@PathVariable Long id) {
            return landlordService.findById(id).orElseThrow(()->new EntityNotFoundException("Landlord with id "+id+" not found" ));
        }


        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Landlord savingLandlord(@RequestBody LandlordCreateRequest landlordCreateRequest) throws Exception {
        Landlord landlord=conversionService.convert(landlordCreateRequest,Landlord.class);
            return landlordService.save(landlord);

        }



        @PutMapping
        @ResponseStatus(HttpStatus.OK)
        public Landlord updateLandlord(@RequestBody LandlordChangeRequest landlordChangeRequest) {
         Landlord landlord=conversionService.convert(landlordChangeRequest,Landlord.class);
            return landlordService.update(landlord);
        }

        @DeleteMapping("/id")
        @ResponseStatus(HttpStatus.OK)
        public Long deleteLandlord(@RequestParam (value="id") Long id) {
            Landlord landlord = landlordService.findById(id).orElseThrow(()->new EntityNotFoundException("Landlord with id "+id+" not found" ));
            return landlordService.delete(landlord);
        }
    }


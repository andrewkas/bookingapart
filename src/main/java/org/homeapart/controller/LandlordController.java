package org.homeapart.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.*;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;
import org.homeapart.domain.User;
import org.homeapart.domain.enums.SystemRole;
import org.homeapart.repository.LandlordRepository;
import org.homeapart.repository.UserRepository;
import org.homeapart.service.LandlordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
@RestController
@RequestMapping("/landlord")
@Api( tags = "LANDLORD")
@RequiredArgsConstructor
public class LandlordController {

        private final LandlordService landlordService;


        @GetMapping
        public ResponseEntity<Object> findAllLandlord() {
            List<Landlord> all = landlordService.findAll();
            return new ResponseEntity<>(all, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Landlord findLandlordById(@PathVariable Long id) {
            return landlordService.findById(id).orElseThrow(()->new UsernameNotFoundException(String.format("No landlord found with id '%d'.", id)));
        }


        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Landlord savingLandlord(@RequestBody LandlordCreateRequest landlordCreateRequest) throws Exception {
            //converters
            Landlord landlord = new Landlord();
                landlord.setName(landlordCreateRequest.getName());
                landlord.setSurname(landlordCreateRequest.getSurname());
                landlord.setCreated(new Timestamp(System.currentTimeMillis()));
                landlord.setChanged(new Timestamp(System.currentTimeMillis()));
                landlord.setLogin(landlordCreateRequest.getLogin());
                landlord.setPassword(landlordCreateRequest.getPassword());
                landlord.setEmail(landlordCreateRequest.getEmail());
                landlord.setPhone(landlordCreateRequest.getPhone());
                landlord.setLandlordRole(new Role(2l,SystemRole.ROLE_MODERATOR));
            return landlordService.save(landlord);

        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Landlord updateLandlord(@PathVariable Long id,
                               @RequestBody LandlordCreateRequest landlordCreateRequest) {

            if (landlordService.findById(id).isPresent()) {
                Landlord landlord = landlordService.findById(id).get();
                landlord.setName(landlordCreateRequest.getName());
                landlord.setSurname(landlordCreateRequest.getSurname());
                landlord.setCreated(new Timestamp(System.currentTimeMillis()));
                landlord.setChanged(new Timestamp(System.currentTimeMillis()));
                landlord.setLogin(landlordCreateRequest.getLogin());
                landlord.setPassword(landlordCreateRequest.getPassword());
                landlord.setEmail(landlordCreateRequest.getEmail());
                landlord.setPhone(landlordCreateRequest.getPhone());
                landlord.setLandlordRole(new Role(2l, SystemRole.ROLE_MODERATOR));

                return landlordService.update(landlord);
            } else {
                Landlord landlord = new Landlord();
                landlord.setName(landlordCreateRequest.getName());
                landlord.setSurname(landlordCreateRequest.getSurname());
                landlord.setCreated(new Timestamp(System.currentTimeMillis()));
                landlord.setChanged(new Timestamp(System.currentTimeMillis()));
                landlord.setLogin(landlordCreateRequest.getLogin());
                landlord.setPassword(landlordCreateRequest.getPassword());
                landlord.setEmail(landlordCreateRequest.getEmail());
                landlord.setPhone(landlordCreateRequest.getPhone());
                landlord.setLandlordRole(new Role(2l, SystemRole.ROLE_MODERATOR));
                return landlordService.save(landlord);
            }
        }

        @PutMapping
        @ResponseStatus(HttpStatus.OK)
        public Landlord updateLandlord(@RequestBody LandlordChangeRequest landlordChangeRequest) {
            Landlord landlord = landlordService.findById(landlordChangeRequest.getId()).orElseThrow(()->new UsernameNotFoundException(String.format("No landlord found with id '%d'.", landlordChangeRequest.getId())));
            landlord.setName(landlordChangeRequest.getName());
            landlord.setSurname(landlordChangeRequest.getSurname());
            landlord.setChanged(new Timestamp(System.currentTimeMillis()));
            landlord.setLogin(landlordChangeRequest.getLogin());
            landlord.setPassword(landlordChangeRequest.getPassword());
            landlord.setEmail(landlordChangeRequest.getEmail());
            landlord.setPhone(landlordChangeRequest.getPhone());
            landlord.setLandlordRole(new Role(2l,SystemRole.ROLE_MODERATOR));

            return landlordService.update(landlord);
        }

        @DeleteMapping("/id")
        @ResponseStatus(HttpStatus.OK)
        public Long deleteLandlord(@RequestParam (value="id") Long id) {
            Landlord landlord = landlordService.findById(id).orElseThrow(()->new UsernameNotFoundException(String.format("No landlord found with id '%d'.", id)));


            return landlordService.delete(landlord);
        }
    }


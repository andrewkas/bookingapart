package org.homeapart.controller;

import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.LandlordCreateRequest;
import org.homeapart.controller.request.UserChangeRequest;
import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.controller.request.UserDeleteRequest;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.User;
import org.homeapart.repository.LandlordRepository;
import org.homeapart.repository.UserRepository;
import org.homeapart.service.LandlordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
@RestController
@RequestMapping("/landlord")
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
            return landlordService.findById(id);
        }


        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Landlord savingLandlord(@RequestBody LandlordCreateRequest landlordCreateRequest) {
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

            //user.setRoles(Collections.singleton(new HibernateRole("ROLE_ADMIN", user)));
            // user.setRole(new HibernateRole(SystemRoles.ROLE_ADMIN, user));
            return landlordService.save(landlord);

        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Landlord updateLandlord(@PathVariable Long id,
                               @RequestBody LandlordCreateRequest landlordCreateRequest) {

            Landlord landlord = landlordService.findById(id);

            landlord.setName(landlordCreateRequest.getName());
            landlord.setSurname(landlordCreateRequest.getSurname());
            landlord.setCreated(new Timestamp(System.currentTimeMillis()));
            landlord.setChanged(new Timestamp(System.currentTimeMillis()));
            landlord.setLogin(landlordCreateRequest.getLogin());
            landlord.setPassword(landlordCreateRequest.getPassword());
            landlord.setEmail(landlordCreateRequest.getEmail());
            landlord.setPhone(landlordCreateRequest.getPhone());

            //user.setRoles(Collections.singleton(new HibernateRole("ROLE_ADMIN", user)));
            /// user.setRole(new HibernateRole(SystemRoles.ROLE_ADMIN, user));
            return landlordService.update(landlord);
        }

        @PutMapping
        @ResponseStatus(HttpStatus.OK)
        public Landlord updateLandlord(@RequestBody LandlordCreateRequest landlordCreateRequest) {

            Landlord landlord = landlordService.findById(landlordCreateRequest.getId());


            landlord.setName(landlordCreateRequest.getName());
            landlord.setSurname(landlordCreateRequest.getSurname());
            landlord.setChanged(new Timestamp(System.currentTimeMillis()));
            landlord.setLogin(landlordCreateRequest.getLogin());
            landlord.setPassword(landlordCreateRequest.getPassword());
            landlord.setEmail(landlordCreateRequest.getEmail());
            landlord.setPhone(landlordCreateRequest.getPhone());


            return landlordService.update(landlord);
        }

        @DeleteMapping
        @ResponseStatus(HttpStatus.OK)
        public Long deleteLandlord(@RequestBody UserDeleteRequest userDeleteRequest) {
            Landlord landlord = landlordService.findById(userDeleteRequest.getId());

            return landlordService.delete(landlord);
        }
    }


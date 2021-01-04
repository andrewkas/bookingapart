package org.homeapart.security.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.LandlordCreateRequest;
import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;
import org.homeapart.domain.User;
import org.homeapart.domain.enums.SystemRole;
import org.homeapart.service.LandlordService;
import org.homeapart.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/registration")
@Api( tags = "REGISTRATION")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    private final LandlordService landlordService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    public ResponseEntity<Map<String,Object>> registrationUser(@RequestBody UserCreateRequest userCreateRequest){

        User user = new User();
        user.setGender(userCreateRequest.getGender());
        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setLogin(userCreateRequest.getLogin());
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        user.setEmail(userCreateRequest.getEmail());
        user.setUserRole((new Role(1l,SystemRole.ROLE_USER)));
        User savedUser = userService.save(user);

        Map<String, Object> result = new HashMap<>();

        result.put("id", savedUser.getId());
        result.put("login", savedUser.getLogin());

        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
    @PostMapping("/landlord")
    public ResponseEntity<Map<String,Object>> registrationLandlord(@RequestBody LandlordCreateRequest landlordCreateRequest){

        Landlord landlord = new Landlord();
        landlord.setName(landlordCreateRequest.getName());
        landlord.setSurname(landlordCreateRequest.getSurname());
        landlord.setPhone(landlordCreateRequest.getPhone());
        landlord.setEmail(landlordCreateRequest.getEmail());
        landlord.setCreated(new Timestamp(System.currentTimeMillis()));
        landlord.setChanged(new Timestamp(System.currentTimeMillis()));
        landlord.setLogin(landlordCreateRequest.getLogin());
        landlord.setPassword(passwordEncoder.encode(landlordCreateRequest.getPassword()));
        landlord.setLandlordRole(new Role(2l,SystemRole.ROLE_MODERATOR));
        Landlord savedLandlord = landlordService.save(landlord);

        Map<String, Object> result = new HashMap<>();

        result.put("id", savedLandlord.getId());
        result.put("login", savedLandlord.getLogin());

        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }





}

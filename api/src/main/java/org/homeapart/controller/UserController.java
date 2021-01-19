package org.homeapart.controller;

import io.swagger.annotations.Api;
import org.homeapart.controller.request.UserChangeRequest;
import org.homeapart.controller.request.UserCreateRequest;

import org.homeapart.domain.User;
import lombok.RequiredArgsConstructor;
import org.homeapart.service.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api( tags = "USER")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ConversionService conversionService;


    @GetMapping
    public ResponseEntity<Object> findAllUsers() {
        List<User> all = userService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User findByLogin(@RequestParam(value = "login") String login){
        return userService.findByLogin(login).orElseThrow(()->new NoResultException("User with login "+login+" not found"));

    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable Long id) {
       return userService.findById(id).orElseThrow(()->new NoResultException("User with id "+id+" not found"));

    }



    @PostMapping
    public ResponseEntity <User> savingUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        User userSave = conversionService.convert(userCreateRequest,User.class);
        return new ResponseEntity(userService.save(userSave), HttpStatus.CREATED);

    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody UserChangeRequest userChangeRequest) {
       User user = conversionService.convert(userChangeRequest,User.class);
        return userService.update(user);
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Long deleteUser(@RequestParam (value="id") Long id) {
        User user = userService.findById(id).orElseThrow(()->new UsernameNotFoundException(String.format("User with id "+id+" not found")));
        return userService.delete(user);
    }


}


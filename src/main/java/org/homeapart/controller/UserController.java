package org.homeapart.controller;

import org.homeapart.controller.request.SearchCriteria;
import org.homeapart.controller.request.UserChangeRequest;
import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.controller.request.UserDeleteRequest;
import org.homeapart.domain.Role;
import org.homeapart.domain.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.homeapart.domain.enums.SystemRole;
import org.homeapart.repository.UserRepository;
import org.homeapart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


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
    @ResponseStatus(HttpStatus.CREATED)
    public User savingUser(@RequestBody UserCreateRequest userCreateRequest) {

        User user = new User();
        user.setGender(userCreateRequest.getGender());
        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setLogin(userCreateRequest.getLogin());
        user.setPassword(userCreateRequest.getPassword());
        user.setEmail(userCreateRequest.getEmail());
        user.setUserRole(new Role(1l,SystemRole.ROLE_USER));
        return userService.save(user);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable Long id,
                           @RequestBody UserCreateRequest userCreateRequest) {

                if(!userService.findById(id).isPresent())throw new EntityNotFoundException("There is no user with id = " + id);
        User user = userService.findById(id).get();
        user.setGender(userCreateRequest.getGender());
        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setLogin(userCreateRequest.getLogin());
        user.setPassword(userCreateRequest.getPassword());
        user.setEmail(userCreateRequest.getEmail());
        user.setUserRole(new Role(1l,SystemRole.ROLE_USER));
        return userService.update(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody UserChangeRequest userChangeRequest) {
        if(!userService.findById(userChangeRequest.getId()).isPresent())throw new EntityNotFoundException("There is no user with id = " + userChangeRequest.getId());
        User user = userService.findById(userChangeRequest.getId()).get();
        user.setGender(userChangeRequest.getGender());
        user.setName(userChangeRequest.getName());
        user.setSurname(userChangeRequest.getSurname());
        user.setBirthDate(userChangeRequest.getBirthDate());
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setLogin(userChangeRequest.getLogin());
        user.setPassword(userChangeRequest.getPassword());
        user.setEmail(userChangeRequest.getEmail());
        user.setUserRole(new Role(1l,SystemRole.ROLE_USER));

        return userService.update(user);
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Long deleteUser(@RequestParam (value="id") Long id) {
        if(!userService.findById(id).isPresent())
            throw new EntityNotFoundException("There is no user with id = " + id);

        User user = userService.findById(id).get();

        return userService.delete(user);
    }


}


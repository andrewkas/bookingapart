package org.homeapart.controller;

import org.homeapart.controller.request.SearchCriteria;
import org.homeapart.controller.request.UserChangeRequest;
import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.controller.request.UserDeleteRequest;
import org.homeapart.domain.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.homeapart.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;


    @GetMapping
    public ResponseEntity<Object> findAllUsers() {
        List<User> all = userRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }


 //   @GetMapping("{/login}")
 //   @ResponseStatus(HttpStatus.OK)
 //   public Optional<User> findByLogin(@PathVariable String login){
 //       return userRepository.findByLogin(login);
 //   }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User savingUser(@RequestBody UserCreateRequest userCreateRequest) {
        //converters
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

        //user.setRoles(Collections.singleton(new HibernateRole("ROLE_ADMIN", user)));
        // user.setRole(new HibernateRole(SystemRoles.ROLE_ADMIN, user));
        return userRepository.save(user);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable Long id,
                           @RequestBody UserCreateRequest userCreateRequest) {

        User user = userRepository.findById(id);

        user.setGender(userCreateRequest.getGender());
        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setLogin(userCreateRequest.getLogin());
        user.setPassword(userCreateRequest.getPassword());
        user.setEmail(userCreateRequest.getEmail());

        //user.setRoles(Collections.singleton(new HibernateRole("ROLE_ADMIN", user)));
        /// user.setRole(new HibernateRole(SystemRoles.ROLE_ADMIN, user));
        return userRepository.update(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody UserChangeRequest userChangeRequest) {

        User user = userRepository.findById(userChangeRequest.getId());

        user.setGender(userChangeRequest.getGender());
        user.setName(userChangeRequest.getName());
        user.setSurname(userChangeRequest.getSurname());
        user.setBirthDate(userChangeRequest.getBirthDate());
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setLogin(userChangeRequest.getLogin());
        user.setPassword(userChangeRequest.getPassword());
        user.setEmail(userChangeRequest.getEmail());


        return userRepository.update(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Long deleteUser(@RequestBody UserDeleteRequest userDeleteRequest) {
        User user = userRepository.findById(userDeleteRequest.getId());

        return userRepository.delete(user);
    }
}


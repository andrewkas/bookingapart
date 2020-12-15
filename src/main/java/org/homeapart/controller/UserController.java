package org.homeapart.controller;

import org.homeapart.controller.request.UserChangeRequest;
import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.domain.User;
import lombok.RequiredArgsConstructor;
import org.homeapart.repository.impl.UserSpringDataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {




    private final UserSpringDataRepository userSpringDataRepository;

    @GetMapping("/data/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<User>> getUsersSpringData(@ApiIgnore Pageable pageable) {
        return new ResponseEntity<>(userSpringDataRepository.findAll(pageable), HttpStatus.OK);
      //  ,new Sort(Sort.Direction.ASC,"name")
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> findUserById(@PathVariable Long id) {
        return userSpringDataRepository.findById(id);
    }



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
        return userSpringDataRepository.save(user);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable Long id,
                                    @RequestBody UserCreateRequest userCreateRequest) {

       User user = userSpringDataRepository.getOne(id);

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
        return userSpringDataRepository.save(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody UserChangeRequest userChangeRequest) {

        User user = userSpringDataRepository.getOne(userChangeRequest.getId());

        user.setGender(userChangeRequest.getGender());
        user.setName(userChangeRequest.getName());
        user.setSurname(userChangeRequest.getSurname());
        user.setBirthDate(userChangeRequest.getBirthDate());
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setLogin(userChangeRequest.getLogin());
        user.setPassword(userChangeRequest.getPassword());
        user.setEmail(userChangeRequest.getEmail());


        return userSpringDataRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<User> userDelete(@PathVariable Long id){
        userSpringDataRepository.deleteById(id);

        return userSpringDataRepository.findAll();
    }

}

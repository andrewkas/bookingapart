package org.homeapart.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.SearchCriteria;
import org.homeapart.controller.request.UserChangeRequest;
import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.domain.User;
import org.homeapart.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
@RequiredArgsConstructor
public class UserController {
    public final UserRepository userRepository;


    @GetMapping
    public ResponseEntity<Object> findAllUsers() {
     //   Object o = UserRepository.testHql();
        List<User> all = userRepository.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<User> userSearch(@ModelAttribute SearchCriteria search) {
        return userRepository.search(search.getQuery());
    }


    @ApiOperation(value = "Endpoint for creation users")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "Auth-Token", defaultValue = "token", required = true, paramType = "header", dataType = "string"),
//            @ApiImplicitParam(name = "query", defaultValue = "query", required = false, paramType = "path", dataType = "string")
//    })
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


        return userRepository.update(user);
    }

}

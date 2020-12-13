package org.homeapart.service;

import org.homeapart.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User save(User user);

    User update(User user);

    User findById(Long userId);

    Optional<User> findByLogin(String login);

    Long delete (User user);

}


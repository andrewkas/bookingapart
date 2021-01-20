package org.homeapart.service;

import org.homeapart.domain.Role;
import org.homeapart.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User save(User user);

    User update(User user);

    Optional<User> findById(Long userId);

    Optional<User> findByLogin(String login);

     void delete (User user);

    List<Role> findRole(Long id);

}


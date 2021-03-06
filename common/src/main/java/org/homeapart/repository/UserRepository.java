package org.homeapart.repository;

import org.homeapart.domain.Role;
import org.homeapart.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<Long, User> {

   // List<User> search(String query);

   Optional<User> findByLogin(String login);
   List<Role> findRole(Long id);

}
